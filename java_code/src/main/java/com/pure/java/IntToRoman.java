package com.pure.java;

public class IntToRoman {

    public static String intToRoman(int num) {
        // Arrays for integer values and Roman numeral symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        // Iterate through the values and symbols
        for (int i = 0; i < values.length; i++) {
            // Append symbols while the number is greater than or equal to the current value
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {3, 58, 1994, 4, 9, 10, 49, 3999};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + intToRoman(testCases[i]));
            // Expected outputs:
            // Test 1: III
            // Test 2: LVIII
            // Test 3: MCMXCIV
            // Test 4: IV
            // Test 5: IX
            // Test 6: X
            // Test 7: XLIX
            // Test 8: MMMCMXCIX
        }
    }
}