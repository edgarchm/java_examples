package com.pure.java;

public class Fibonacci {

    public static int fibonacci(int n) {
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }
        // Recursive case: return the sum of the previous two Fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + fibonacci(testCases[i]));
            // Expected outputs:
            // Test 1: 0
            // Test 2: 1
            // Test 3: 1
            // Test 4: 2
            // Test 5: 3
            // Test 6: 5
            // Test 7: 8
            // Test 8: 13
            // Test 9: 21
            // Test 10: 34
            // Test 11: 55
        }
    }
}