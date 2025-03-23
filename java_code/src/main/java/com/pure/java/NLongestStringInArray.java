package com.pure.java;

import java.util.Arrays;
import java.util.Comparator;

public class NLongestStringInArray {

    public static String[] findNLongestStrings(String[] arr, int n) {
        // 2.1. Comments: Handle edge cases.
        if (arr == null || arr.length == 0 || n <= 0) {
            return new String[0];
        }

        // 2.1. Comments: Sort the array by string length in descending order.
        Arrays.sort(arr, Comparator.comparingInt(String::length).reversed());

        // 2.1. Comments: Handle cases where n is greater than or equal to the array length.
        if (n >= arr.length) {
            return arr;
        }

        // 2.1. Comments: Create a new array to store the n longest strings.
        String[] result = new String[n];

        // 2.1. Comments: Copy the n longest strings into the result array.
        System.arraycopy(arr, 0, result, 0, n);

        // 2.1. Comments: Return the array of n longest strings.
        return result;
    }

    public static void main(String[] args) {
        String[] test1 = {"apple", "banana", "cherry", "date", "grapefruit"};
        int n1 = 3;
        System.out.println("Test 1: " + Arrays.toString(findNLongestStrings(test1, n1))); // Expected output: [grapefruit, banana, cherry]

        String[] test2 = {"short", "medium", "longer", "longest"};
        int n2 = 4;
        System.out.println("Test 2: " + Arrays.toString(findNLongestStrings(test2, n2))); // Expected output: [longest, longer, medium, short]

        String[] test3 = {"a", "bb", "ccc", "dddd", "eeeee"};
        int n3 = 2;
        System.out.println("Test 3: " + Arrays.toString(findNLongestStrings(test3, n3))); // Expected output: [eeeee, dddd]

        String[] test4 = {"one", "two", "three"};
        int n4 = 5;
        System.out.println("Test 4: " + Arrays.toString(findNLongestStrings(test4, n4))); // Expected output: [three, two, one]

        String[] test5 = null;
        int n5 = 2;
        System.out.println("Test 5: " + Arrays.toString(findNLongestStrings(test5, n5))); // Expected output: []

        String[] test6 = {};
        int n6 = 2;
        System.out.println("Test 6: " + Arrays.toString(findNLongestStrings(test6, n6))); // Expected output: []

        String[] test7 = {"a","b","c"};
        int n7 = 0;
        System.out.println("Test 7: " + Arrays.toString(findNLongestStrings(test7, n7))); // Expected output: []
    }
}