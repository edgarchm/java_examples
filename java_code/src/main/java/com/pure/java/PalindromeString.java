package com.pure.java;

public class PalindromeString {
    /**
     * Determines if a given string is a palindrome.
     *
     * @param s The input string.
     * @return True if the string is a palindrome, False otherwise.
     */
    public static boolean isPalindromeString(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        StringBuilder processedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                processedString.append(Character.toLowerCase(c));
            }
        }

        // Compare the processed string with its reversed version
        String original = processedString.toString();
        String reversed = processedString.reverse().toString();
        return original.equals(reversed);
    }

    public static void main(String[] args) {
        // Test cases

        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Is '" + s1 + "' a palindrome? " + isPalindromeString(s1)); // Output: True

        String s2 = "racecar";
        System.out.println("Is '" + s2 + "' a palindrome? " + isPalindromeString(s2)); // Output: True

        String s3 = "hello";
        System.out.println("Is '" + s3 + "' a palindrome? " + isPalindromeString(s3)); // Output: False

        String s4 = " ";
        System.out.println("Is '" + s4 + "' a palindrome? " + isPalindromeString(s4)); // Output: True

        String s5 = "a";
        System.out.println("Is '" + s5 + "' a palindrome? " + isPalindromeString(s5)); // Output: True

        String s6 = ".,";
        System.out.println("Is '" + s6 + "' a palindrome? " + isPalindromeString(s6)); // Output: True

        String s7 = "0P";
        System.out.println("Is '" + s7 + "' a palindrome? " + isPalindromeString(s7)); // Output: False
    }
}
