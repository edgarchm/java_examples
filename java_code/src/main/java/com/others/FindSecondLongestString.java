package com.others;

import java.util.Arrays;
import java.util.Comparator;

public class FindSecondLongestString {

    public static String findSecondLongestString(String[] arr) {
        // 2.1. Comments: Handle edge cases.
        if (arr == null || arr.length < 2) {
            return null;
        }

        // 2.1. Comments: Sort the array by string length in descending order.
        Arrays.sort(arr, Comparator.comparingInt(String::length).reversed());

        // 2.1. Comments: Return the second longest string.
        return arr[1];
    }

    public static void main(String[] args) {
        String[] test1 = {"apple", "banana", "cherry", "date", "grapefruit"};
        System.out.println("Test 1: " + findSecondLongestString(test1)); // Expected output: banana

        String[] test2 = {"short", "medium", "longer", "longest"};
        System.out.println("Test 2: " + findSecondLongestString(test2)); // Expected output: longer

        String[] test3 = {"a", "bb", "ccc", "dddd", "eeeee"};
        System.out.println("Test 3: " + findSecondLongestString(test3)); // Expected output: dddd

        String[] test4 = {"one"};
        System.out.println("Test 4: " + findSecondLongestString(test4)); // Expected output: null

        String[] test5 = null;
        System.out.println("Test 5: " + findSecondLongestString(test5)); // Expected output: null

        String[] test6 = {};
        System.out.println("Test 6: " + findSecondLongestString(test6)); // Expected output: null

        String[] test7 = {"a", "bb"};
        System.out.println("Test 7: " + findSecondLongestString(test7)); // Expected output: a
    }
}