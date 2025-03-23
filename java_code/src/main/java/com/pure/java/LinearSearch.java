package com.pure.java;

public class LinearSearch {

    public static int linearSearch(int[] array, int target) {
        // 2. Iterate through the array.
        for (int i = 0; i < array.length; i++) {
            // 3. Compare the current element with the target.
            if (array[i] == target) {
                // 4. Return the index if found.
                return i;
            }
        }
        // 5. Return -1 if not found.
        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};
        int target1 = 3;
        int[] test2 = {5, 4, 3, 2, 1};
        int target2 = 1;
        int[] test3 = {10, 20, 30, 40, 50};
        int target3 = 25;
        int[] test4 = {};
        int target4 = 1;
        int[] test5 = {1,1,1,1,1};
        int target5 = 1;

        System.out.println("Test 1: " + linearSearch(test1, target1)); // Expected: 2
        System.out.println("Test 2: " + linearSearch(test2, target2)); // Expected: 4
        System.out.println("Test 3: " + linearSearch(test3, target3)); // Expected: -1
        System.out.println("Test 4: " + linearSearch(test4, target4)); // Expected: -1
        System.out.println("Test 5: " + linearSearch(test5, target5)); // Expected: 0
    }
}