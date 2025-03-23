package com.pure.java;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class RemoveDuplicateStringsInArray {

    public static String[] removeDuplicates(String[] arr) {
        // 2.1. Comments: Handle edge cases.
        if (arr == null || arr.length == 0) {
            return new String[0];
        }

        // 2.1. Comments: Use LinkedHashSet to maintain insertion order and avoid duplicates.
        Set<String> uniqueStrings = new LinkedHashSet<>();

        // 2.1. Comments: Iterate through the input array and add unique strings to the set.
        for (String str : arr) {
            uniqueStrings.add(str);
        }

        // 2.1. Comments: Convert the set to an array.
        String[] result = new String[uniqueStrings.size()];
        int index = 0;
        for (String str : uniqueStrings) {
            result[index++] = str;
        }

        // 2.1. Comments: Return the array of unique strings.
        return result;
    }

    public static void main(String[] args) {
        String[] test1 = {"apple", "banana", "cherry", "apple", "date", "banana", "grapefruit"};
        System.out.println("Test 1: " + Arrays.toString(removeDuplicates(test1))); // Expected output: [apple, banana, cherry, date, grapefruit]

        String[] test2 = {"one", "one", "one", "one"};
        System.out.println("Test 2: " + Arrays.toString(removeDuplicates(test2))); // Expected output: [one]

        String[] test3 = {"a", "b", "c", "d", "e"};
        System.out.println("Test 3: " + Arrays.toString(removeDuplicates(test3))); // Expected output: [a, b, c, d, e]

        String[] test4 = {};
        System.out.println("Test 4: " + Arrays.toString(removeDuplicates(test4))); // Expected output: []

        String[] test5 = null;
        System.out.println("Test 5: " + Arrays.toString(removeDuplicates(test5))); // Expected output: []

        String[] test6 = {"aa", "bb", "aa", "cc", "bb", "dd"};
        System.out.println("Test 6: " + Arrays.toString(removeDuplicates(test6))); // Expected output: [aa, bb, cc, dd]
    }
}