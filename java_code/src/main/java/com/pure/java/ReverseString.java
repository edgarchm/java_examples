package com.pure.java;

public class ReverseString {

    public static String reverseString(String s) {
        // 1. Initialize an empty string called reversedString.
        String reversedString = "";

        // 2. Iterate through the input string from the last character to the first character.
        for (int i = s.length() - 1; i >= 0; i--) {
            // 3. For each character in the input string, append it to reversedString.
            reversedString += s.charAt(i);
        }
        // 4. Return reversedString.
        return reversedString;
    }

    public static void main(String[] args) {
        String[] test = {"hello", "world", "racecar", "A man a plan a canal Panama"};
        System.out.println("Test 1: " + reverseString(test[0])); // Expected output: olleh
        System.out.println("Test 2: " + reverseString(test[1])); // Expected output: dlrow
        System.out.println("Test 3: " + reverseString(test[2])); // Expected output: racecar
        System.out.println("Test 4: " + reverseString(test[3])); // Expected output: amaN a lanac a nalp a nam A
    }
}