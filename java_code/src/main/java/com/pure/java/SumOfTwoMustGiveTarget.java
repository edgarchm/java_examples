package com.pure.java;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoMustGiveTarget {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        return new int[] {}; // Return an empty array if no solution is found
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, -2, 3, 6, 1, 5, 7 };
        int target = 5;
        int[] result = twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two numbers in the list add up to " + target);
        }
    }
}