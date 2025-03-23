package com.pure.java;

public class SubsequenceChecker {
    /**
     * Determines if string s is a subsequence of string t.
     *
     * @param s The potential subsequence string.
     * @param t The string to check for the subsequence.
     * @return True if s is a subsequence of t, False otherwise.
     */
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0; // Pointer for string s
        int tIndex = 0; // Pointer for string t

        // Loop while there are characters remaining in both strings
        while (sIndex < s.length() && tIndex < t.length()) {
            // If characters match, move the s pointer forward
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            // Always move the t pointer forward
            tIndex++;
        }

        // If we've matched all characters of s, it's a subsequence
        return sIndex == s.length();
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Is '" + s1 + "' a subsequence of '" + t1 + "'? " + isSubsequence(s1, t1));

        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Is '" + s2 + "' a subsequence of '" + t2 + "'? " + isSubsequence(s2, t2));

        String s3 = "";
        String t3 = "ahbgdc";
        System.out.println("Is '" + s3 + "' a subsequence of '" + t3 + "'? " + isSubsequence(s3, t3));

        String s4 = "acb";
        String t4 = "ahbgdc";
        System.out.println("Is '" + s4 + "' a subsequence of '" + t4 + "'? " + isSubsequence(s4, t4));

        String s5 = "b";
        String t5 = "c";
        System.out.println("Is '" + s5 + "' a subsequence of '" + t5 + "'? " + isSubsequence(s5, t5));
    }
}

