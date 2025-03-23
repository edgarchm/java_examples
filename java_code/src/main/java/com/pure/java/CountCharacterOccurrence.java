package com.pure.java;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterOccurrence {

    public static Map<Character, Integer> countCharacterOccurrences(String input) {
        // 1. Initialize an empty dictionary (or map) to store character counts.
        Map<Character, Integer> charCounts = new HashMap<>();

        // 2. Iterate through each character in the input string.
        for (char c : input.toCharArray()) {
            // 3. For each character:
            // 3.1 If the character is already a key in the dictionary, increment its count.
            // 3.2 If the character is not in the dictionary, add it as a key with a count of 1.
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // 4. Return the dictionary containing the character counts.
        return charCounts;
    }

    public static void main(String[] args) {
        String[] test = {"hello", "world", "racecar", "A man a plan a canal Panama"};
        for (int i = 0; i < test.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + countCharacterOccurrences(test[i]));
        }
    }
}