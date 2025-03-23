package com.pure.java;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        // 2.1. Comments: Handle edge cases.
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 2.1. Comments: Find the middle index.
        int mid = arr.length / 2;

        // 2.1. Comments: Recursively sort the left half.
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] sortedLeft = mergeSort(left);

        // 2.1. Comments: Recursively sort the right half.
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        int[] sortedRight = mergeSort(right);

        // 2.1. Comments: Merge the sorted halves.
        return merge(sortedLeft, sortedRight);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // 2.1. Comments: Merge the two sorted arrays.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // 2.1. Comments: Copy any remaining elements from the left array.
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // 2.1. Comments: Copy any remaining elements from the right array.
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {5, 1, 9, 3, 7};
        System.out.println("Test 1: " + Arrays.toString(mergeSort(test1))); // Expected output: [1, 3, 5, 7, 9]

        int[] test2 = {10, 20, 30, 40, 50};
        System.out.println("Test 2: " + Arrays.toString(mergeSort(test2))); // Expected output: [10, 20, 30, 40, 50]

        int[] test3 = {50, 40, 30, 20, 10};
        System.out.println("Test 3: " + Arrays.toString(mergeSort(test3))); // Expected output: [10, 20, 30, 40, 50]

        int[] test4 = {2, 2, 2, 2, 2};
        System.out.println("Test 4: " + Arrays.toString(mergeSort(test4))); // Expected output: [2, 2, 2, 2, 2]

        int[] test5 = {1};
        System.out.println("Test 5: " + Arrays.toString(mergeSort(test5))); // Expected output: [1]

        int[] test6 = {};
        System.out.println("Test 6: " + Arrays.toString(mergeSort(test6))); // Expected output: []

        int[] test7 = {5, 2, 8, 1, 9, 4, 7, 3, 6};
        System.out.println("Test 7: " + Arrays.toString(mergeSort(test7))); // Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

    }
}