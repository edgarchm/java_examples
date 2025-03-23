package com.pure.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvenNumberGenerator implements Iterator<Integer> {
    private List<Integer> numbers;
    private int currentIndex = 0;

    public EvenNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < numbers.size()) {
            int number = numbers.get(currentIndex);
            if (number % 2 == 0) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Integer next() {
        int evenNumber = numbers.get(currentIndex);
        currentIndex++;
        return evenNumber;
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Iterate through the generated even numbers
        EvenNumberGenerator generator = new EvenNumberGenerator(numbers);
        while (generator.hasNext()) {
            System.out.println(generator.next());
        }

        System.out.println("---");

        // Another example
        List<Integer> numbers2 = List.of(1, 3, 5, 7, 9);
        generator = new EvenNumberGenerator(numbers2);
        while (generator.hasNext()) {
            System.out.println(generator.next());
        }

        System.out.println("---");

        // Another example
        List<Integer> numbers3 = List.of(2, 4, 6, 8, 10);
        generator = new EvenNumberGenerator(numbers3);
        while (generator.hasNext()) {
            System.out.println(generator.next());
        }

        System.out.println("---");

        // Manually iterating through the generator
        generator = new EvenNumberGenerator(numbers);
        if (generator.hasNext()) {
            System.out.println(generator.next()); // Output: 2
        }
        if (generator.hasNext()) {
            System.out.println(generator.next()); // Output: 4
        }
        if (generator.hasNext()) {
            System.out.println(generator.next()); // Output: 6
        }

        // Converting generated numbers to a list
        generator = new EvenNumberGenerator(numbers);
        List<Integer> evenList = new ArrayList<>();
        while (generator.hasNext()) {
            evenList.add(generator.next());
        }
        System.out.println(evenList); // Output: [2, 4, 6, 8, 10]
    }
}
