package com.pure.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeNumberGenerator implements Iterator<Integer> {
    private final int limit;              // Upper limit for prime number generation
    private final List<Integer> primes;  // List to store found primes
    private int current;                 // Current number being checked

    public PrimeNumberGenerator(int limit) {
        this.limit = limit;
        this.primes = new ArrayList<>();
        this.current = 2; // Start with the first prime number
    }

    @Override
    public boolean hasNext() {
        // Check if there are more primes to generate
        while (current <= limit) {
            if (isPrime(current)) {
                return true;
            }
            current++; // Increment to check the next number
        }
        return false;
    }

    @Override
    public Integer next() {
        // Return the next prime number and advance
        int nextPrime = current;
        primes.add(nextPrime);
        current++;
        return nextPrime;
    }

    private boolean isPrime(int num) {
        // Check if a number is prime using the list of previously found primes
        for (int p : primes) {
            if (p * p > num) {
                break; // If p squared is greater than num, then num is prime
            }
            if (num % p == 0) {
                return false; // If divisible by any earlier prime, not prime
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage:

        // Generate primes up to 100
        PrimeNumberGenerator generator = new PrimeNumberGenerator(100);

        while (generator.hasNext()) {
            System.out.println(generator.next());
        }
    }
}
