package com.pure.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateLetters {

    public static List<String> removeDuplicates(List<String> arr) {
        // Handle edge cases
        if (arr == null || arr.isEmpty()) {
            return new ArrayList<>();
        }

        // Use LinkedHashSet to maintain insertion order and avoid duplicates
        Set<String> uniqueElements = new LinkedHashSet<>(arr);

        // Convert the set back to a list to get the unique elements in order
        return new ArrayList<>(uniqueElements);
    }

    public static void main(String[] args) {
        List<String> test1 = Arrays.asList("a", "b", "b", "c", "d", "d", "e");
        System.out.println("Test 1: " + removeDuplicates(test1)); // Expected output: [a, b, c, d, e]

        List<String> test2 = Arrays.asList("a", "a", "a", "a", "a");
        System.out.println("Test 2: " + removeDuplicates(test2)); // Expected output: [a]

        List<String> test3 = Arrays.asList("a", "b", "c", "d", "e");
        System.out.println("Test 3: " + removeDuplicates(test3)); // Expected output: [a, b, c, d, e]

        List<String> test4 = Arrays.asList();
        System.out.println("Test 4: " + removeDuplicates(test4)); // Expected output: []

        List<String> test5 = null;
        System.out.println("Test 5: " + removeDuplicates(test5)); // Expected output: []

        List<String> test6 = Arrays.asList("e", "d", "c", "b", "a", "a", "a", "b", "b", "c", "c", "d", "d", "e", "e");
        System.out.println("Test 6: " + removeDuplicates(test6)); // Expected output: [e, d, c, b, a]
    }
}

