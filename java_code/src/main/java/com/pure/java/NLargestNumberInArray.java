package com.pure.java;

import java.util.Arrays;

public class NLargestNumberInArray {

    public static int[] findNLargest(int[] arr, int n) {
        // 2.1. Comments: Sort the array in descending order.
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }

        // 2.1. Comments: Handle cases where n is larger than the array length.
        if (n > arr.length) {
            return reversedArr;
        }

        // 2.1. Comments: Create a new array to store the n largest elements.
        int[] result = new int[n];

        // 2.1. Comments: Copy the n largest elements into the result array.
        for (int i = 0; i < n; i++) {
            result[i] = reversedArr[i];
        }

        // 2.1. Comments: Return the array of n largest elements.
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {5, 1, 9, 3, 7};
        int n1 = 3;
        System.out.println("Test 1: " + Arrays.toString(findNLargest(test1, n1))); // Expected output: [9, 7, 5]

        int[] test2 = {10, 20, 30, 40, 50};
        int n2 = 5;
        System.out.println("Test 2: " + Arrays.toString(findNLargest(test2, n2))); // Expected output: [50, 40, 30, 20, 10]

        int[] test3 = {2, 2, 2, 2, 2};
        int n3 = 2;
        System.out.println("Test 3: " + Arrays.toString(findNLargest(test3, n3))); // Expected output: [2, 2]

        int[] test4 = {1, 2, 3};
        int n4 = 5;
        System.out.println("Test 4: " + Arrays.toString(findNLargest(test4, n4))); // Expected output: [3, 2, 1]

        int[] test5 = null;
        int n5 = 2;
        System.out.println("Test 5: " + Arrays.toString(findNLargest(test5, n5))); // Expected output: []

        int[] test6 = {};
        int n6 = 2;
        System.out.println("Test 6: " + Arrays.toString(findNLargest(test6, n6))); // Expected output: []
    }
}