package com.pure.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SummaryRanges {
    /**
     * Generates summary ranges from a sorted integer array.
     *
     * @param nums The input integer array.
     * @return A list of strings representing the summary ranges.
     */
    public List<String> summaryRanges(int[] nums) {
        // Handle empty input.
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // Sort the array.
        Arrays.sort(nums);

        List<String> result = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];

        // Iterate through the array.
        for (int i = 1; i < nums.length; i++) {
            // Check if the current number is consecutive.
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                // Add the current range to the result.
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                // Update start and end for the next range.
                start = nums[i];
                end = nums[i];
            }
        }

        // Add the last range to the result.
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();

        // Example 1:
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        List<String> result1 = solution.summaryRanges(nums1);
        System.out.println("Example 1: " + result1); // Output: Example 1: [0->2, 4->5, 7]

        // Example 2:
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        List<String> result2 = solution.summaryRanges(nums2);
        System.out.println("Example 2: " + result2); // Output: Example 2: [0, 2->4, 6, 8->9]

        // Example 3:
        int[] nums3 = {};
        List<String> result3 = solution.summaryRanges(nums3);
        System.out.println("Example 3: " + result3); // Output: Example 3: []

        // Example 4:
        int[] nums4 = {-1};
        List<String> result4 = solution.summaryRanges(nums4);
        System.out.println("Example 4: " + result4); // Output: Example 4: [-1]
    }
}