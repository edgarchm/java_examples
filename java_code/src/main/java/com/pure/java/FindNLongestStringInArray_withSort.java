package com.pure.java;

import java.util.Arrays;
import java.util.Comparator;

public class FindNLongestStringInArray_withSort {

    public static String findNthLongestStringInArray_withSort(String[] arr, int n) {
        // 2.1. Comments: Handle edge cases.
        if (arr == null || arr.length < n) {
            return null;
        }

        // 2.1. Comments: Sort the array by string length in descending order.
        Arrays.sort(arr, Comparator.comparingInt(String::length).reversed());

        // 2.1. Comments: Return the nth longest string.
        return arr[n - 1];
    }

    public static void main(String[] args) {
        String[] test1 = {"apple", "banana", "cherry", "date", "grapefruit"};
        System.out.println("Test 1 (2nd): " + findNthLongestStringInArray_withSort(test1, 2)); // Expected output: banana
        System.out.println("Test 1 (3rd): " + findNthLongestStringInArray_withSort(test1, 3)); // Expected output: cherry
        System.out.println("Test 1 (4th): " + findNthLongestStringInArray_withSort(test1, 4)); // Expected output: apple

        String[] test2 = {"short", "medium", "longer", "longest"};
        System.out.println("Test 2 (2nd): " + findNthLongestStringInArray_withSort(test2, 2)); // Expected output: longer
        System.out.println("Test 2 (3rd): " + findNthLongestStringInArray_withSort(test2, 3)); // Expected output: medium
        System.out.println("Test 2 (4th): " + findNthLongestStringInArray_withSort(test2, 4)); // Expected output: short

        String[] test3 = {"a", "bb", "ccc", "dddd", "eeeee"};
        System.out.println("Test 3 (2nd): " + findNthLongestStringInArray_withSort(test3, 2)); // Expected output: dddd
        System.out.println("Test 3 (3rd): " + findNthLongestStringInArray_withSort(test3, 3)); // Expected output: ccc
        System.out.println("Test 3 (4th): " + findNthLongestStringInArray_withSort(test3, 4)); // Expected output: bb

        String[] test4 = {"one", "two"};
        System.out.println("Test 4 (2nd): " + findNthLongestStringInArray_withSort(test4, 2)); // Expected output: one
        System.out.println("Test 4 (3rd): " + findNthLongestStringInArray_withSort(test4, 3)); // Expected output: null

        String[] test5 = null;
        System.out.println("Test 5 (2nd): " + findNthLongestStringInArray_withSort(test5, 2)); // Expected output: null

        String[] test6 = {};
        System.out.println("Test 6 (2nd): " + findNthLongestStringInArray_withSort(test6, 2)); // Expected output: null
    }
}