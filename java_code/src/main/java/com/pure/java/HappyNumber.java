package com.pure.java;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    /**
     * Determines if a number is a happy number.
     *
     * @param n The number to check.
     * @return true if n is a happy number, false otherwise.
     */
    public boolean happyNumber(int n) {
        // Use a HashSet to detect cycles.
        Set<Integer> seen = new HashSet<>();

        // Continue until n becomes 1 or a cycle is detected.
        while (n != 1 && !seen.contains(n)) {
            // Add the current number to the set of seen numbers.
            seen.add(n);
            // Calculate the sum of the squares of the digits.
            n = calculateSumOfSquares(n);
        }

        // If n is 1, it's a happy number.
        return n == 1;
    }

    /**
     * Calculates the sum of the squares of the digits of a number.
     *
     * @param n The number to process.
     * @return The sum of the squares of the digits.
     */
    private int calculateSumOfSquares(int n) {
        int sum = 0;
        // Iterate through each digit of the number.
        while (n > 0) {
            // Get the last digit.
            int digit = n % 10;
            // Add the square of the digit to the sum.
            sum += digit * digit;
            // Remove the last digit from the number.
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();

        // Example 1: 19 is a happy number
        int num1 = 19;
        boolean result1 = solution.happyNumber(num1);
        System.out.println(num1 + " is happy: " + result1); // Output: 19 is happy: true

        // Example 2: 2 is not a happy number
        int num2 = 2;
        boolean result2 = solution.happyNumber(num2);
        System.out.println(num2 + " is happy: " + result2); // Output: 2 is happy: false

        // Example 3: 7 is a happy number
        int num3 = 7;
        boolean result3 = solution.happyNumber(num3);
        System.out.println(num3 + " is happy: " + result3); // Output: 7 is happy: true

        // Example 4: 116 is not a happy number
        int num4 = 116;
        boolean result4 = solution.happyNumber(num4);
        System.out.println(num4 + " is happy: " + result4); // Output: 116 is happy: false
    }
}