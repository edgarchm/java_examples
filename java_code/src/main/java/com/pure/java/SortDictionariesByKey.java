package com.pure.java;

import java.util.*;

public class SortDictionariesByKey {
    /**
     * Sorts a list of maps (dictionaries) by the value of a specific key.
     *
     * @param dictionaries A list of maps representing dictionaries.
     * @param key          The key to sort by.
     * @return A new list of dictionaries sorted by the specified key.
     */
    public static List<Map<String, Object>> sortDictionariesByKey(List<Map<String, Object>> dictionaries, String key) {
        // Create a copy of the input list to avoid modifying the original
        List<Map<String, Object>> sortedList = new ArrayList<>(dictionaries);

        // Sort the list using a Comparator
        sortedList.sort((map1, map2) -> {
            // Get the values associated with the specified key
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            // Compare the values assuming they are Comparable (e.g., String, Integer)
            return ((Comparable<Object>) value1).compareTo(value2);
        });

        // Return the sorted list
        return sortedList;
    }

    public static void main(String[] args) {
        // Example usage:

        // Data set 1
        List<Map<String, Object>> data = Arrays.asList(
                new HashMap<>(Map.of("name", "Alice", "age", 30, "city", "New York")),
                new HashMap<>(Map.of("name", "Bob", "age", 25, "city", "London")),
                new HashMap<>(Map.of("name", "Charlie", "age", 35, "city", "Paris")),
                new HashMap<>(Map.of("name", "David", "age", 20, "city", "Tokyo"))
        );

        // Sort by age
        List<Map<String, Object>> sortedByAge = sortDictionariesByKey(data, "age");
        System.out.println("Sorted by age: " + sortedByAge);

        // Sort by name
        List<Map<String, Object>> sortedByName = sortDictionariesByKey(data, "name");
        System.out.println("Sorted by name: " + sortedByName);

        // Data set 2
        List<Map<String, Object>> data2 = Arrays.asList(
                new HashMap<>(Map.of("name", "Alice", "score", 90, "city", "New York")),
                new HashMap<>(Map.of("name", "Bob", "score", 85, "city", "London")),
                new HashMap<>(Map.of("name", "Charlie", "score", 95, "city", "Paris")),
                new HashMap<>(Map.of("name", "David", "score", 80, "city", "Tokyo"))
        );

        // Sort by score
        List<Map<String, Object>> sortedByScore = sortDictionariesByKey(data2, "score");
        System.out.println("Sorted by score: " + sortedByScore);

        // Data set 3
        List<Map<String, Object>> data3 = Arrays.asList(
                new HashMap<>(Map.of("city", "New York", "population", 8000000)),
                new HashMap<>(Map.of("city", "London", "population", 9000000)),
                new HashMap<>(Map.of("city", "Paris", "population", 2000000)),
                new HashMap<>(Map.of("city", "Tokyo", "population", 14000000))
        );

        // Sort by population
        List<Map<String, Object>> sortedByPopulation = sortDictionariesByKey(data3, "population");
        System.out.println("Sorted by population: " + sortedByPopulation);
    }
}
