package com.pure.java;

import java.util.HashMap;
import java.util.Map;

class NumberConverter {

    private static final Map<Integer, String> NUMBERS = new HashMap<>();
    private static final Map<String, Integer> WORDS = new HashMap<>();

    static {
        NUMBERS.put(0, "Zero");
        NUMBERS.put(1, "One");
        NUMBERS.put(2, "Two");
        NUMBERS.put(3, "Three");
        NUMBERS.put(4, "Four");
        NUMBERS.put(5, "Five");
        NUMBERS.put(6, "Six");
        NUMBERS.put(7, "Seven");
        NUMBERS.put(8, "Eight");
        NUMBERS.put(9, "Nine");
        NUMBERS.put(10, "Ten");
        NUMBERS.put(11, "Eleven");
        NUMBERS.put(12, "Twelve");
        NUMBERS.put(13, "Thirteen");
        NUMBERS.put(14, "Fourteen");
        NUMBERS.put(15, "Fifteen");
        NUMBERS.put(16, "Sixteen");
        NUMBERS.put(17, "Seventeen");
        NUMBERS.put(18, "Eighteen");
        NUMBERS.put(19, "Nineteen");
        NUMBERS.put(20, "Twenty");
        NUMBERS.put(30, "Thirty");
        NUMBERS.put(40, "Forty");
        NUMBERS.put(50, "Fifty");
        NUMBERS.put(60, "Sixty");
        NUMBERS.put(70, "Seventy");
        NUMBERS.put(80, "Eighty");
        NUMBERS.put(90, "Ninety");

        for (Map.Entry<Integer, String> entry : NUMBERS.entrySet()) {
            WORDS.put(entry.getValue().toLowerCase(), entry.getKey());
        }

        WORDS.put("hundred", 100);
        WORDS.put("thousand", 1000);
        WORDS.put("million", 1000000);
        WORDS.put("billion", 1000000000);
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        if (num < 0) {
            return "Minus " + numberToWords(Math.abs(num));
        }
        return convert(num);
    }

    private String convert(int num) {
        if (NUMBERS.containsKey(num)) {
            return NUMBERS.get(num);
        }
        if (num < 100) {
            return NUMBERS.get(num / 10 * 10) + (num % 10 != 0 ? " " + NUMBERS.get(num % 10) : "");
        }
        if (num < 1000) {
            return NUMBERS.get(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convert(num % 100) : "");
        }
        if (num < 1000000) {
            return convert(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convert(num % 1000) : "");
        }
        if (num < 1000000000) {
            return convert(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + convert(num % 1000000) : "");
        }
        return convert(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convert(num % 1000000000) : "");
    }

    public int wordsToNumber(String words) {
        if (words == null || words.isEmpty()) {
            return 0;
        }
        String[] parts = words.toLowerCase().split(" ");
        int result = 0;
        int current = 0;
        boolean negative = false;

        for (String part : parts) {
            if (part.equals("minus")) {
                negative = true;
                continue;
            }
            if (WORDS.containsKey(part)) {
                int value = WORDS.get(part);
                if (value == 100) {
                    current *= value;
                } else if (value >= 1000) {
                    result += current * value;
                    current = 0;
                } else {
                    current += value;
                }
            }
        }
        result += current;
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        NumberConverter converter = new NumberConverter();

        // Example 1: Number to words.
        System.out.println("Example 1: " + converter.numberToWords(1234567)); // Output: Example 1: One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven

        // Example 2: Words to number.
        System.out.println("Example 2: " + converter.wordsToNumber("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven")); // Output: Example 2: 1234567

        // Example 3: Number to words (zero).
        System.out.println("Example 3: " + converter.numberToWords(0)); // Output: Example 3: Zero

        // Example 4: Words to number (zero).
        System.out.println("Example 4: " + converter.wordsToNumber("Zero")); // Output: Example 4: 0

        // Example 5: Number to words (negative).
        System.out.println("Example 5: " + converter.numberToWords(-123)); // Output: Example 5: Minus One Hundred Twenty Three

        // Example 6: words to number (negative)
        System.out.println("Example 6: " + converter.wordsToNumber("Minus One Hundred Twenty Three")); // Output: Example 6: -123
    }
}