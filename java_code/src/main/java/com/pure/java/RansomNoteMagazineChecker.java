package com.pure.java;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteMagazineChecker {
    /**
     * Determines if a ransom note can be constructed from a magazine.
     *
     * @param ransomNote The ransom note string.
     * @param magazine   The magazine string.
     * @return True if the ransom note can be constructed, False otherwise.
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        // Create a map to count character occurrences in the magazine
        Map<Character, Integer> magazineCounts = new HashMap<>();

        // Count the occurrences of each character in the magazine
        for (char c : magazine.toCharArray()) {
            magazineCounts.put(c, magazineCounts.getOrDefault(c, 0) + 1);
        }

        // Check if the ransom note can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (!magazineCounts.containsKey(c) || magazineCounts.get(c) == 0) {
                return false; // If the character is unavailable or used up, return false
            }
            magazineCounts.put(c, magazineCounts.get(c) - 1); // Decrease the count for the used character
        }

        return true; // If all characters in the ransom note are accounted for, return true
    }

    public static void main(String[] args) {
        // Test cases
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println("Can construct '" + ransomNote1 + "' from '" + magazine1 + "'? " + canConstruct(ransomNote1, magazine1)); // Output: False

        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println("Can construct '" + ransomNote2 + "' from '" + magazine2 + "'? " + canConstruct(ransomNote2, magazine2)); // Output: False

        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println("Can construct '" + ransomNote3 + "' from '" + magazine3 + "'? " + canConstruct(ransomNote3, magazine3)); // Output: True

        String ransomNote4 = "";
        String magazine4 = "aab";
        System.out.println("Can construct '" + ransomNote4 + "' from '" + magazine4 + "'? " + canConstruct(ransomNote4, magazine4)); // Output: True

        String ransomNote5 = "abc";
        String magazine5 = "aabbcc";
        System.out.println("Can construct '" + ransomNote5 + "' from '" + magazine5 + "'? " + canConstruct(ransomNote5, magazine5)); // Output: True

        String ransomNote6 = "abc";
        String magazine6 = "aabbc";
        System.out.println("Can construct '" + ransomNote6 + "' from '" + magazine6 + "'? " + canConstruct(ransomNote6, magazine6)); // Output: False
    }
}

