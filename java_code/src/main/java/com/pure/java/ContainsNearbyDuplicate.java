package com.pure.java;

import java.util.HashMap;
import java.util.Map;

class ContainsNearbyDuplicate {
    /**
     * Checks if there are two distinct indices i and j such that nums[i] == nums[j]
     * and abs(i - j) <= k.
     *
     * @param nums The integer array.
     * @param k    The maximum absolute difference between indices.
     * @return true if there are such indices, false otherwise.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap to store number and its index.
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Check if the number is already in the map.
            if (map.containsKey(nums[i])) {
                // Get the previous index of the number.
                int j = map.get(nums[i]);
                // Check if the absolute difference between indices is within the limit.
                if (Math.abs(i - j) <= k) {
                    return true; // Found a matching pair within the limit.
                }
            }
            // Store the current number and its index in the map.
            map.put(nums[i], i);
        }
        // No matching pair found within the limit.
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate solution = new ContainsNearbyDuplicate();

        // Example 1:
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        boolean result1 = solution.containsNearbyDuplicate(nums1, k1);
        System.out.println("Example 1: " + result1); // Output: Example 1: true

        // Example 2:
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        boolean result2 = solution.containsNearbyDuplicate(nums2, k2);
        System.out.println("Example 2: " + result2); // Output: Example 2: true

        // Example 3:
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        boolean result3 = solution.containsNearbyDuplicate(nums3, k3);
        System.out.println("Example 3: " + result3); // Output: Example 3: false

        // Example 4:
        int[] nums4 = {1, 2, 1};
        int k4 = 0;
        boolean result4 = solution.containsNearbyDuplicate(nums4, k4);
        System.out.println("Example 4: " + result4); // Output: Example 4: false

        // Example 5:
        int[] nums5 = {1, 2, 3, 1, 2, 3};
        int k5 = 2;
        boolean result5 = solution.containsNearbyDuplicate(nums5, k5);
        System.out.println("Example 5: " + result5); // Output: Example 5: false

    }
}
