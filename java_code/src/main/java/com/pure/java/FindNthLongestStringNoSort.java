package com.pure.java;

public class FindNthLongestStringNoSort {

    public static String findNthLongestString(String[] arr, int n) {
        // 2.1. Comments: Handle edge cases.
        if (arr == null || arr.length < n) {
            return null;
        }

        // 2.1. Comments: Implement selection sort based on string length.
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].length() > arr[maxIndex].length()) {
                    maxIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        // 2.1. Comments: Return the nth longest string.
        return arr[n - 1];
    }

    public static void main(String[] args) {
        String[] test1 = {"apple", "banana", "cherry", "date", "grapefruit"};
        System.out.println("Test 1 (2nd): " + findNthLongestString(test1, 2)); // Expected output: banana
        System.out.println("Test 1 (3rd): " + findNthLongestString(test1, 3)); // Expected output: cherry
        System.out.println("Test 1 (4th): " + findNthLongestString(test1, 4)); // Expected output: apple

        String[] test2 = {"short", "medium", "longer", "longest"};
        System.out.println("Test 2 (2nd): " + findNthLongestString(test2, 2)); // Expected output: longer
        System.out.println("Test 2 (3rd): " + findNthLongestString(test2, 3)); // Expected output: medium
        System.out.println("Test 2 (4th): " + findNthLongestString(test2, 4)); // Expected output: short

        String[] test3 = {"a", "bb", "ccc", "dddd", "eeeee"};
        System.out.println("Test 3 (2nd): " + findNthLongestString(test3, 2)); // Expected output: dddd
        System.out.println("Test 3 (3rd): " + findNthLongestString(test3, 3)); // Expected output: ccc
        System.out.println("Test 3 (4th): " + findNthLongestString(test3, 4)); // Expected output: bb

        String[] test4 = {"one", "two"};
        System.out.println("Test 4 (2nd): " + findNthLongestString(test4, 2)); // Expected output: one
        System.out.println("Test 4 (3rd): " + findNthLongestString(test4, 3)); // Expected output: null

        String[] test5 = null;
        System.out.println("Test 5 (2nd): " + findNthLongestString(test5, 2)); // Expected output: null

        String[] test6 = {};
        System.out.println("Test 6 (2nd): " + findNthLongestString(test6, 2)); // Expected output: null
    }
}