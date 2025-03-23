package com.pure.java;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class MergeArraysRemoveDups {
        public static void mergeArraysRemoveDups(String[] location1Numbers, String[] location2Numbers) {
            // Step 2: Create a HashSet to store unique phone numbers
            HashSet<String> uniqueNumbers = new HashSet<>();

            // Step 3: Add phone numbers from location 1 to the HashSet
            for (String number : location1Numbers) {
                uniqueNumbers.add(number);
            }

            // Step 4: Add phone numbers from location 2 to the HashSet
            for (String number : location2Numbers) {
                uniqueNumbers.add(number);
            }

            // Step 5: Create an ArrayList from the HashSet
            List<String> uniqueList = new ArrayList<>(uniqueNumbers);

            // Step 6: Print the ArrayList of unique phone numbers
            System.out.println(uniqueList);
        }

        public static void main(String[] args) {
            String[] location1 = {"1234567", "9876543", "1112223", "1234567"};
            String[] location2 = {"9876543", "5556667", "3334445", "6667778"};

            System.out.print("Combined Unique Phone Numbers: ");
            mergeArraysRemoveDups(location1, location2); // Expected: [1234567, 9876543, 1112223, 5556667, 3334445, 6667778] or similar ordering.
        }
}
