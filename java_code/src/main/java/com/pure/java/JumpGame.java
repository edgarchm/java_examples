package com.pure.java;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        // 2.1. Comments: Handle edge cases.
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        // 2.1. Comments: Initialize reachable to 0.
        int reachable = 0;

        // 2.1. Comments: Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // 2.1. Comments: Check if the current index is reachable.
            if (i > reachable) {
                return false;
            }

            // 2.1. Comments: Update reachable.
            reachable = Math.max(reachable, i + nums[i]);

            // 2.1. Comments: Check if the last index is reachable.
            if (reachable >= nums.length - 1) {
                return true;
            }
        }

        // 2.1. Comments: If the loop finishes, return true.
        return true;
    }

    public static void main(String[] args) {
        int[] test1 = {2, 3, 1, 1, 4};
        System.out.println("Test 1: " + canJump(test1)); // Expected output: true

        int[] test2 = {3, 2, 1, 0, 4};
        System.out.println("Test 2: " + canJump(test2)); // Expected output: false

        int[] test3 = {0};
        System.out.println("Test 3: " + canJump(test3)); // Expected output: true

        int[] test4 = {2, 0, 0};
        System.out.println("Test 4: " + canJump(test4)); // Expected output: true

        int[] test5 = {1, 0, 1, 0};
        System.out.println("Test 5: " + canJump(test5)); // Expected output: false

        int[] test6 = {2, 5, 0, 0};
        System.out.println("Test 6: " + canJump(test6)); // Expected output: true
    }
}