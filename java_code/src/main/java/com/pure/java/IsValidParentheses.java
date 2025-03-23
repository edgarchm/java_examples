package com.pure.java;

import java.util.Stack;

class IsValidParentheses {
    /**
     * Determines if a string containing parentheses is valid.
     *
     * @param s The input string.
     * @return true if the string is valid, false otherwise.
     */
    public boolean isValidParentheses(String s) {
        // Handle empty string.
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Push opening bracket onto the stack.
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // Check for matching closing bracket.
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket.
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false; // Mismatched brackets.
                }
            }
        }

        // Check if all opening brackets are matched.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValidParentheses solution = new IsValidParentheses();

        // Example 1: Valid parentheses.
        String s1 = "()";
        boolean result1 = solution.isValidParentheses(s1);
        System.out.println("Example 1: " + result1); // Output: Example 1: true

        // Example 2: Valid nested parentheses.
        String s2 = "()[]{}";
        boolean result2 = solution.isValidParentheses(s2);
        System.out.println("Example 2: " + result2); // Output: Example 2: true

        // Example 3: Invalid closing bracket.
        String s3 = "(]";
        boolean result3 = solution.isValidParentheses(s3);
        System.out.println("Example 3: " + result3); // Output: Example 3: false

        // Example 4: Invalid order of brackets.
        String s4 = "([)]";
        boolean result4 = solution.isValidParentheses(s4);
        System.out.println("Example 4: " + result4); // Output: Example 4: false

        // Example 5: Valid nested with mixed types.
        String s5 = "{[]}";
        boolean result5 = solution.isValidParentheses(s5);
        System.out.println("Example 5: " + result5); // Output: Example 5: true

        // Example 6: Unmatched opening bracket.
        String s6 = "(";
        boolean result6 = solution.isValidParentheses(s6);
        System.out.println("Example 6: " + result6); // Output: Example 6: false

        // Example 7: Valid nested brackets.
        String s7 = "([])";
        boolean result7 = solution.isValidParentheses(s7);
        System.out.println("Example 7: " + result7); // Output: Example 7: true
    }
}