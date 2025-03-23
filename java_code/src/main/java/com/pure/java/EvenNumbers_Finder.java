package com.pure.java;

import java.util.ArrayList;
import java.util.List;

public class EvenNumbers_Finder {
    /**
     * Takes a list of integers and returns a new list containing only the even numbers.
     *
     * @param numbers A list of integers.
     * @return A list of even integers.
     */
    public static List<Integer> getEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        return evenNumbers;
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenList = getEvenNumbers(myList);
        System.out.println(evenList); // Output: [2, 4, 6, 8, 10]

        List<Integer> myList2 = List.of(1, 3, 5, 7, 9);
        List<Integer> evenList2 = getEvenNumbers(myList2);
        System.out.println(evenList2); // Output: []

        List<Integer> myList3 = List.of(2, 4, 6, 8, 10);
        List<Integer> evenList3 = getEvenNumbers(myList3);
        System.out.println(evenList3); // Output: [2, 4, 6, 8, 10]
    }
}