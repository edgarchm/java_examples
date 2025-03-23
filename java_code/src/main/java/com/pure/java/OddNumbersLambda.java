package com.pure.java;

import java.util.List;
import java.util.stream.Collectors;

public class OddNumbersLambda {
    /**
     * Returns a list of all odd numbers from the input list using the Stream API.
     *
     * @param numbers A list of integers.
     * @return A list containing all the odd numbers from the input list.
     */
    public static List<Integer> getOddNumbersLambda(List<Integer> numbers) {
        // Use the Stream API to filter odd numbers and collect them into a new list
        return numbers.stream()
                .filter(num -> num % 2 != 0) // Lambda expression to check if the number is odd
                .collect(Collectors.toList()); // Collect the filtered numbers into a list
    }

    public static void main(String[] args) {
        // Example usage:

        // Example list containing a range of integers
        List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Call the method to get odd numbers
        List<Integer> oddList = getOddNumbersLambda(myList);
        // Print the list of odd numbers
        System.out.println(oddList); // Output: [1, 3, 5, 7, 9]

        // Example list containing only even numbers
        List<Integer> myList2 = List.of(2, 4, 6, 8, 10);
        // Call the method to get odd numbers
        List<Integer> oddList2 = getOddNumbersLambda(myList2);
        // Print the result, which should be an empty list
        System.out.println(oddList2); // Output: []

        // Example list containing only odd numbers
        List<Integer> myList3 = List.of(1, 3, 5, 7, 9);
        // Call the method to get odd numbers
        List<Integer> oddList3 = getOddNumbersLambda(myList3);
        // Print the list of odd numbers
        System.out.println(oddList3); // Output: [1, 3, 5, 7, 9]

        // Example list with negative numbers and zero
        List<Integer> myList4 = List.of(-1, -2, -3, 0, 1, 2, 3);
        // Call the method to get odd numbers
        List<Integer> oddList4 = getOddNumbersLambda(myList4);
        // Print the list of odd numbers
        System.out.println(oddList4); // Output: [-1, -3, 1, 3]
    }
}
