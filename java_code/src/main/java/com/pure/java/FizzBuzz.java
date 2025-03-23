package com.pure.java;

public class FizzBuzz {

    /**
     * Prints the appropriate response for each value i in the set {1,2,...n} in ascending order,
     * each on a separate line.
     *
     * @param n The upper limit of values to test (inclusive).
     */
    public static void fizzBuzz(int n) {
        // Iterate through the range from 1 to n
        for (int i = 1; i <= n; i++) {
            StringBuilder output = new StringBuilder(); // Initialize an empty string for each number

            // Append "Fizz" if the number is divisible by 3
            if (i % 3 == 0) {
                output.append("Fizz");
            }

            // Append "Buzz" if the number is divisible by 5
            if (i % 5 == 0) {
                output.append("Buzz");
            }

            // Print the result
            if (output.length() > 0) { // Check if the string is not empty (multiple of 3 or 5)
                System.out.println(output);
            } else {
                System.out.println(i); // If the string is empty, print the number itself
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        fizzBuzz(15);
        // Expected output:
        // 1
        // 2
        // Fizz
        // 4
        // Buzz
        // Fizz
        // 7
        // 8
        // Fizz
        // Buzz
        // 11
        // Fizz
        // 13
        // 14
        // FizzBuzz
    }
}

