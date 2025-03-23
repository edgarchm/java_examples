package com.pure.java;

import java.util.Arrays;

public class RotateArray {

    public static void rotateArray(int[] nums, int k) {
        /*
         * Rotates an array to the right by k steps.
         * Args:
         * nums: The integer array to rotate.
         * k: The number of steps to rotate.
         */
        int n = nums.length;
        k %= n; // Handle k > n (wrap around)

        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining elements (from k to n-1)
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        /*
         * Reverses a portion of an array in-place.
         * Args:
         * nums: The integer array.
         * start: The starting index of the portion to reverse.
         * end: The ending index of the portion to reverse.
         */
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(nums1, 3);
        System.out.println("Test 1: " + Arrays.toString(nums1)); // Output: [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {-1, -100, 3, 99};
        rotateArray(nums2, 2);
        System.out.println("Test 2: " + Arrays.toString(nums2)); // Output: [3, 99, -1, -100]

        int[] nums3 = {1, 2};
        rotateArray(nums3, 3);
        System.out.println("Test 3: " + Arrays.toString(nums3)); // Output: [2, 1]

        int[] nums4 = {1, 2, 3};
        rotateArray(nums4, 4);
        System.out.println("Test 4: " + Arrays.toString(nums4)); // Output: [2, 3, 1]
    }
}

