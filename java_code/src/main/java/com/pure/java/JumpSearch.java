package com.pure.java;
public class JumpSearch {
    public static int jumpSearch(int[] array, int target) {
        int n = array.length;// 2. Determine the size of the array.
        int step = (int) Math.sqrt(n);// 3. Calculate the jump step.
        int previous = 0;// 4. Initialize previous index.
        // 5. While the element at the jump index is less than the target.
        while (previous < n && array[Math.min(step, n) - 1] < target) {
            previous = step;
            step += (int) Math.sqrt(n);
            if (previous >= n) {
                return -1;
            }
        }
        while (previous < Math.min(step, n)) { // 6. Perform a linear search.
            if (array[previous] == target) { // 7. If the target value is found, return its index.
                return previous;
            }
            previous++;
        }
        return -1; // 8. If the linear search completes without finding the target, return -1.
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int target1 = 55;
        int[] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target2 = 1;
        int[] test3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target3 = 11;
        int[] test4 = {1};
        int target4 = 1;
        int[] test5 = {1};
        int target5 = 2;

        System.out.println("Test 1: " + jumpSearch(test1, target1)); // Expected: 10
        System.out.println("Test 2: " + jumpSearch(test2, target2)); // Expected: 0
        System.out.println("Test 3: " + jumpSearch(test3, target3)); // Expected: -1
        System.out.println("Test 4: " + jumpSearch(test4, target4)); // Expected: 0
        System.out.println("Test 5: " + jumpSearch(test5, target5)); // Expected: -1
    }
}