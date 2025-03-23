package com.pure.java;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static int romanToInt(String s) {
        // Create a map to store Roman numeral values
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        int toRet = 0;
        int oldVal = 0;

        // Iterate from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char romNum = s.charAt(i);
            int newVal = romans.get(romNum);

            // Check for subtraction case
            if (newVal < oldVal) {
                toRet -= newVal;
            } else {
                toRet += newVal;
            }

            oldVal = newVal;
        }

        return toRet;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {"III", "LVIII", "MCMXCIV"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + romanToInt(testCases[i]));
            // Expected outputs:
            // Test 1: 3
            // Test 2: 58
            // Test 3: 1994
        }
    }
}
