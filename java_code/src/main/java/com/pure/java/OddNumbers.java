package com.pure.java;

import java.util.ArrayList;
import java.util.List;

public class OddNumbers {
    /**
     * This method returns a list of all odd numbers from the input list.
     *
     * @param numbers A list of integers.
     * @return A list containing all the odd numbers from the input list.
     */
    public static List<Integer> getOddNumbers(List<Integer> numbers) {
        // Initialize a new list to store the odd numbers
        List<Integer> oddNumbers = new ArrayList<>();

        // Loop through each number in the input list
        for (int num : numbers) {
            // Check if the current number is odd (remainder is not 0 when divided by 2)
            if (num % 2 != 0) {
                // Add the odd number to the new list
                oddNumbers.add(num);
            }
        }
        // Return the list of odd numbers
        return oddNumbers;
    }

    public static void main(String[] args) {
        // Example usage:

        // Example list containing a range of integers
        List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Call the method to get all odd numbers from myList
        List<Integer> oddList = getOddNumbers(myList);
        // Print the list of odd numbers
        System.out.println(oddList); // Output: [1, 3, 5, 7, 9]

        // Example list containing only even numbers
        List<Integer> myList2 = List.of(2, 4, 6, 8, 10);
        // Call the method to get all odd numbers from myList2
        List<Integer> oddList2 = getOddNumbers(myList2);
        // Print the result, which should be an empty list
        System.out.println(oddList2); // Output: []

        // Example list containing only odd numbers
        List<Integer> myList3 = List.of(1, 3, 5, 7, 9);
        // Call the method to get all odd numbers from myList3
        List<Integer> oddList3 = getOddNumbers(myList3);
        // Print the list of odd numbers
        System.out.println(oddList3); // Output: [1, 3, 5, 7, 9]

        // Example list containing negative and zero integers
        List<Integer> myList4 = List.of(-1, -2, -3, 0, 1, 2, 3);
        // Call the method to get all odd numbers from myList4
        List<Integer> oddList4 = getOddNumbers(myList4);
        // Print the list of odd numbers
        System.out.println(oddList4); // Output: [-1, -3, 1, 3]
    }
}