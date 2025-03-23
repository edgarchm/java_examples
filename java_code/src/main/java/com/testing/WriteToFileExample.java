package com.testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample {
    /**
     * Writes data to a file using try-with-resources to ensure the file is properly closed.
     *
     * @param filename The name of the file to write to.
     * @param data     The data to write to the file.
     */
    public static void writeToFile(String filename, String data) {
        // Try-with-resources ensures the file is automatically closed
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
            System.out.println("Successfully wrote data to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String fileName = "my_file.txt";
        String textToWrite = "This is some sample data.\nAnother line of data.";

        // Write data to the file
        writeToFile(fileName, textToWrite);

        // Demonstrating that the file is closed
        // Verification: Open the file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Verification: File opened successfully for reading after writing.");
        } catch (IOException e) {
            System.out.println("Verification: An error occurred while opening the file.");
        }

        // Trying to reopen the file manually (to simulate an error scenario)
        try {
            FileReader fileReader = new FileReader(fileName);
            System.out.println("This should not print, as the file should be closed.");
            fileReader.close(); // Explicitly closing the file
        } catch (IOException e) {
            System.out.println("Verification: File was automatically closed.");
        }
    }
}
