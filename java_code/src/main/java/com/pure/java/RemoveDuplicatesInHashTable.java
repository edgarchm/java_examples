package com.pure.java;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class RemoveDuplicatesInHashTable {

    public static int[] removeDuplicates(int[] arr) {
        // 2.1. Comments: Handle edge cases.
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        // 2.1. Comments: Use HashSet for fast lookups.
        Set<Integer> seen = new HashSet<>();

        // 2.1. Comments: Use LinkedHashSet to maintain insertion order.
        Set<Integer> uniqueElements = new LinkedHashSet<>();

        // 2.1. Comments: Iterate through the input array.
        for (int num : arr) {
            // 2.1. Comments: Check if the element has been seen.
            if (!seen.contains(num)) {
                // 2.1. Comments: Add the element to both sets.
                seen.add(num);
                uniqueElements.add(num);
            }
        }

        // 2.1. Comments: Convert the LinkedHashSet to an array.
        int[] result = new int[uniqueElements.size()];
        int index = 0;
        for (int num : uniqueElements) {
            result[index++] = num;
        }

        // 2.1. Comments: Return the array of unique elements.
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 2, 3, 4, 4, 5};
        System.out.println("Test 1: " + Arrays.toString(removeDuplicates(test1))); // Expected output: [1, 2, 3, 4, 5]

        int[] test2 = {1, 1, 1, 1, 1};
        System.out.println("Test 2: " + Arrays.toString(removeDuplicates(test2))); // Expected output: [1]

        int[] test3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + Arrays.toString(removeDuplicates(test3))); // Expected output: [1, 2, 3, 4, 5]

        int[] test4 = {};
        System.out.println("Test 4: " + Arrays.toString(removeDuplicates(test4))); // Expected output: []

        int[] test5 = null;
        System.out.println("Test 5: " + Arrays.toString(removeDuplicates(test5))); // Expected output: []

        int[] test6 = {5,4,3,2,1,1,1,2,2,3,3,4,4,5,5};
        System.out.println("Test 6: " + Arrays.toString(removeDuplicates(test6))); // Expected output: [5, 4, 3, 2, 1]
    }
}
