package com.testing;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class InsuranceQueryTests {

    public static Map<String, Map<String, Double>> calculateAveragePremiums(String jdbcUrl, String username, String password) {
        Map<String, Map<String, Double>> results = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT state, strftime('%Y-%m', start_date) AS month_year, AVG(premium) AS average_premium " +
                             "FROM premiums " +
                             "GROUP BY state, month_year " +
                             "ORDER BY state, month_year")) {

            while (resultSet.next()) {
                String state = resultSet.getString("state");
                String monthYear = resultSet.getString("month_year");
                double averagePremium = resultSet.getDouble("average_premium");
                results.computeIfAbsent(state, k -> new HashMap<>()).put(monthYear, averagePremium);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:premiums.db";
        String username = "";
        String password = "";

        // Create a test database and table
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS premiums");
            statement.executeUpdate("CREATE TABLE premiums (policy_id INTEGER, user_id INTEGER, state TEXT, start_date TEXT, end_date TEXT, premium REAL)");

            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('CA', '2023-01-01', 100.00)");
            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('CA', '2023-01-15', 120.00)");
            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('NY', '2023-01-01', 150.00)");
            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('NY', '2023-02-01', 160.00)");
            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('TX', '2023-02-15', 200.00)");
            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('TX', '2023-02-28', 220.00)");
            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('FL', '2023-03-01', 300.00)");
            statement.executeUpdate("INSERT INTO premiums (state, start_date, premium) VALUES ('FL', '2023-03-31', 350.00)");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map<String, Map<String, Double>> averagePremiums = calculateAveragePremiums(jdbcUrl, username, password);

        averagePremiums.forEach((state, monthData) -> {
            System.out.println("State: " + state);
            monthData.forEach((monthYear, premium) -> {
                System.out.println("  " + monthYear + ": " + premium);
            });
        });

        // Query Tests:
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             Statement statement = connection.createStatement()) {

            // Test Case 1: Successful Query - Calculate Average Premium for a Specific State and Month
            String query1 = "SELECT AVG(premium) FROM premiums WHERE state = 'CA' AND strftime('%Y-%m', start_date) = '2023-01'";
            try (ResultSet resultSet1 = statement.executeQuery(query1)) {
                if (resultSet1.next()) {
                    System.out.println("Query 1 Result: Average CA premium in 2023-01 = " + resultSet1.getDouble(1));
                }
            }

            // Test Case 2: Successful Query - Retrieve All Data for a Specific User (if user_id exists)
            String query2 = "SELECT * FROM premiums WHERE user_id = 1";
            try (ResultSet resultSet2 = statement.executeQuery(query2)) {
                System.out.println("Query 2 Result:");
                while (resultSet2.next()) {
                    System.out.println("  " + resultSet2.getInt("policy_id") + ", " + resultSet2.getString("state") + ", " + resultSet2.getString("start_date") + ", " + resultSet2.getDouble("premium"));
                }
            }

            // Test Case 3: Failed Query - Attempt to Insert a Record with Incorrect Data Type
            String query3 = "INSERT INTO premiums (state, start_date, premium) VALUES ('AZ', '2023-04-01', 'abc')";
            try {
                statement.executeUpdate(query3);
                System.out.println("Query 3: Insertion should have failed!"); // This should not execute
            } catch (SQLException e) {
                System.out.println("Query 3: Insertion failed as expected: " + e.getMessage());
            }

            // Test Case 4: Failed Query - Attempt to Select from a Non-Existent Table
            String query4 = "SELECT * FROM non_existent_table";
            try {
                statement.executeQuery(query4);
                System.out.println("Query 4: Select should have failed!"); // This should not execute
            } catch (SQLException e) {
                System.out.println("Query 4: Select failed as expected: " + e.getMessage());
            }

            // Test Case 5: Successful Query - Count the Number of Premiums for a Specific State
            String query5 = "SELECT COUNT(*) FROM premiums WHERE state = 'NY'";
            try (ResultSet resultSet5 = statement.executeQuery(query5)) {
                if (resultSet5.next()) {
                    System.out.println("Query 5 Result: Number of NY premiums = " + resultSet5.getInt(1));
                }
            }

            // Test Case 6: Failed Query - Attempt to Insert a Record with a Null Value into a Non-Nullable Column (if column is non-nullable)
            String query6 = "INSERT INTO premiums (policy_id, state, start_date, premium) VALUES (NULL, 'WA', '2023-05-01', 500.00)";
            try {
                statement.executeUpdate(query6);
                System.out.println("Query 6: Insertion should have failed!");
            } catch (SQLException e) {
                System.out.println("Query 6: Insertion failed as expected: " + e.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}