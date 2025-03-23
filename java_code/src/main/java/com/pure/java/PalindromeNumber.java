package com.pure.java;
class PalindromeNumber {
    /**
     * Determines if a number is a palindrome.
     *
     * @param x The number to check.
     * @return true if the number is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {// 1. Handle negative numbers
            return false;
        }
        if (x < 10) {// 2. Handle single-digit numbers
            return true;
        }
        int originalX = x;// 3. Store original number
        int reversedX = 0;// 4. Initialize reversed number

        while (x > 0) {// 5. Reverse the number
            int lastDigit = x % 10;
            reversedX = reversedX * 10 + lastDigit;
            x = x / 10;
        }

        return originalX == reversedX;// 6. Compare original and reversed numbers
    }

    public static void main(String[] args) {
        PalindromeNumber palindrome = new PalindromeNumber();

        int[] testNumbers = {121, -121, 10, 0, 12321, 5};

        for (int i = 0; i < testNumbers.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + palindrome.isPalindrome(testNumbers[i]));
            // Expected Output: True, False, False, True, True, True
        }
    }
}
