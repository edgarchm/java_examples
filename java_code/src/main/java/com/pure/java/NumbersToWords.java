package com.pure.java;

public class NumbersToWords {

    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "",        // 0
            "",        // 1
            "Twenty",  // 2
            "Thirty",  // 3
            "Forty",   // 4
            "Fifty",   // 5
            "Sixty",   // 6
            "Seventy", // 7
            "Eighty",  // 8
            "Ninety"   // 9
    };

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private static String helper(int num) {
        String result = "";
        if (num < 20) {
            result = units[num];
        } else if (num < 100) {
            result = tens[num / 10] + ((num % 10 != 0) ? " " : "") + units[num % 10];
        } else if (num < 1000) {
            result = units[num / 100] + " Hundred" + ((num % 100 != 0) ? " " : "") + helper(num % 100);
        } else if (num < 1000000) {
            result = helper(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " " : "") + helper(num % 1000);
        } else if (num < 1000000000) {
            result = helper(num / 1000000) + " Million" + ((num % 1000000 != 0) ? " " : "") + helper(num % 1000000);
        } else {
            result = helper(num / 1000000000) + " Billion" + ((num % 1000000000 != 0) ? " " : "") + helper(num % 1000000000);
        }
        return result.trim();
    }

    public static void main(String[] args) {
        int[] test = {0, 123, 12345, 1234567, 1234567891};
        System.out.println("Test 1: " + numberToWords(test[0])); // Expected output: Zero
        System.out.println("Test 2: " + numberToWords(test[1])); // Expected output: One Hundred Twenty Three
        System.out.println("Test 3: " + numberToWords(test[2])); // Expected output: Twelve Thousand Three Hundred Forty Five
        System.out.println("Test 4: " + numberToWords(test[3])); // Expected output: One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
        System.out.println("Test 5: " + numberToWords(test[4])); // Expected output: One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One
    }
}