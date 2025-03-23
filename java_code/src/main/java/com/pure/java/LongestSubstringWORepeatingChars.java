package com.pure.java;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWORepeatingChars {

    public static String longestSubstring(String s) {
        // 1. Initialize a Set to keep track of characters in the current substring.
        Set<Character> charSet = new HashSet<>();
        // 2. Initialize two pointers, left and right, to 0.
        int left = 0;
        int right = 0;
        // 3. Initialize maxLength to 0.
        int maxLength = 0;
        // 4. Initialize longestSubstring to an empty string.
        String longestSubstring = "";

        // 5. While right is less than the length of the string:
        while (right < s.length()) {
            // 5.1 If the character at right is not in the Set:
            if (!charSet.contains(s.charAt(right))) {
                // 5.1.1 Add the character to the Set.
                charSet.add(s.charAt(right));
                // 5.1.2 If right - left + 1 is greater than maxLength:
                if (right - left + 1 > maxLength) {
                    // 5.1.2.1 Update maxLength to right - left + 1.
                    maxLength = right - left + 1;
                    // 5.1.2.2 Update longestSubstring to the substring from left to right + 1.
                    longestSubstring = s.substring(left, right + 1);
                }
                // 5.1.3 Increment right.
                right++;
            } else {
                // 5.2 Else:
                // 5.2.1 Remove the character at left from the Set.
                charSet.remove(s.charAt(left));
                // 5.2.2 Increment left.
                left++;
            }
        }
        // 6. Return longestSubstring.
        return longestSubstring;
    }

    public static void main(String[] args) {
        String[] test = {"abcabcbb", "bbbbb", "pwwkew", "", "au", "mississippi", "chihuahua"};
        String longest = "";
        int longestLength = 0;

        for (int i = 0; i < test.length; i++) {
            String currentLongest = longestSubstring(test[i]);
            System.out.println("Test " + (i + 1) + ": " + currentLongest);
            if (currentLongest.length() > longestLength) {
                longestLength = currentLongest.length();
                longest = currentLongest;
            }
        }

        System.out.println("The longest substring without repeating characters among the given strings is: " + longest);
    }
}