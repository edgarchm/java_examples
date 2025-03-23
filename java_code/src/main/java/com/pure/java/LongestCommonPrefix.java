package com.pure.java;

class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        // 1. If the input array is null or empty, return an empty string.
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 2. Initialize the prefix variable with the first string in the array.
        String prefix = strs[0];

        // 3. Iterate through the rest of the strings in the array.
        for (int i = 1; i < strs.length; i++) {
            // 4. For each string, while the current string does not start with the prefix:
            while (strs[i].indexOf(prefix) != 0) {
                // a. Remove the last character from the prefix.
                prefix = prefix.substring(0, prefix.length() - 1);
                // b. If the prefix becomes empty, return an empty string.
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        // 5. Return the final prefix.
        return prefix;
    }

    public static void main(String[] args) {
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"apple"};
        String[] test4 = {""};
        String[] test5 = {"c","acc","ccc"};
        String[] test6 = null;

        System.out.println("Test 1: " + longestCommonPrefix(test1)); // Expected output: "fl"
        System.out.println("Test 2: " + longestCommonPrefix(test2)); // Expected output: ""
        System.out.println("Test 3: " + longestCommonPrefix(test3)); // Expected output: "apple"
        System.out.println("Test 4: " + longestCommonPrefix(test4)); // Expected output: ""
        System.out.println("Test 5: " + longestCommonPrefix(test5)); // Expected output: ""
        System.out.println("Test 6: " + longestCommonPrefix(test6)); // Expected output: ""
    }
}
