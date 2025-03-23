package com.pure.java;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    /**
     * Reverses the order of words in a given string.
     *
     * @param s The input string.
     * @return The string with words reversed.
     */
    public String reverseWords(String s) {
        // Split the string into a list of words
        String[] words = s.trim().split("\\s+"); // Trim whitespace and split by spaces
        List<String> reversedWords = new ArrayList<>();

        // Iterate over the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversedWords.add(words[i]);
        }

        // Join the reversed words with spaces
        return String.join(" ", reversedWords);
    }

    public static void main(String[] args) {
        ReverseWords solution = new ReverseWords();

        // Test cases
        String test1 = "the sky is blue";
        String test2 = "  hello world  ";
        String test3 = "a good   example";

        System.out.println("Test 1: " + solution.reverseWords(test1)); // Expected output: "blue is sky the"
        System.out.println("Test 2: " + solution.reverseWords(test2)); // Expected output: "world hello"
        System.out.println("Test 3: " + solution.reverseWords(test3)); // Expected output: "example good a"
    }
}
