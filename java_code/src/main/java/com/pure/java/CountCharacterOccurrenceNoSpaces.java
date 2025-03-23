package com.pure.java;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterOccurrenceNoSpaces {

    public static Map<Character, Integer> countCharacterOccurrencesNoSpaces(String input) {
        // 2. Initialize an empty dictionary (or map) to store character counts.
        Map<Character, Integer> charCounts = new HashMap<>();

        // 3. Iterate through each character in the input string.
        for (char c : input.toCharArray()) {
            // 4. For each character:
            if (c != ' ') { // Check if the character is not a space
                // 4.1 If the character is already a key in the dictionary, increment its count.
                // 4.2 If the character is not in the dictionary, add it as a key with a count of 1.
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
        }

        // 5. Return the dictionary containing the character counts.
        return charCounts;
    }

    public static void main(String[] args) {
        String[] test = {"hello", "world", "racecar", "A man a plan a canal Panama"};
        for (int i = 0; i < test.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + countCharacterOccurrencesNoSpaces(test[i]));
        }
    }
}