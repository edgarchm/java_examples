package com.pure.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateLetters {

    public static Set<Character> findDuplicateLetters(String text) {
        if (text == null || text.isEmpty()) {
            return new HashSet<>();
        }

        text = text.toLowerCase();
        Map<Character, Integer> charCounts = new HashMap<>();
        Set<Character> duplicates = new HashSet<>();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (charCounts.containsKey(c)) {
                    charCounts.put(c, charCounts.get(c) + 1);
                    duplicates.add(c);
                } else {
                    charCounts.put(c, 1);
                }
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        String string1 = "programming";
        Set<Character> duplicates1 = findDuplicateLetters(string1);
        System.out.println("Duplicates in '" + string1 + "': " + duplicates1);

        String string2 = "Hello, World!";
        Set<Character> duplicates2 = findDuplicateLetters(string2);
        System.out.println("Duplicates in '" + string2 + "': " + duplicates2);

        String string3 = "No duplicates here";
        Set<Character> duplicates3 = findDuplicateLetters(string3);
        System.out.println("Duplicates in '" + string3 + "': " + duplicates3);

        String string4 = "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz";
        Set<Character> duplicates4 = findDuplicateLetters(string4);
        System.out.println("Duplicates in '" + string4 + "': " + duplicates4);

        String string5 = "AaBbCc";
        Set<Character> duplicates5 = findDuplicateLetters(string5);
        System.out.println("Duplicates in '" + string5 + "': " + duplicates5);
    }
}