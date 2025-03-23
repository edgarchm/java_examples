package com.pure.java;

public class CoinConvert {

    public static void computeChange(int cents) {
        if (cents < 0) {
            System.out.println("Invalid input. Cents must be non-negative.");
            return;
        }

        int quarters = cents / 25;
        cents %= 25;

        int dimes = cents / 10;
        cents %= 10;

        int nickels = cents / 5;
        cents %= 5;

        int pennies = cents;

        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);
    }

    public static void main(String[] args) {
        int centsValue = 87;
        System.out.println("For " + centsValue + " cents:");
        computeChange(centsValue);

        centsValue = 123;
        System.out.println("\nFor " + centsValue + " cents:");
        computeChange(centsValue);

        centsValue = 5;
        System.out.println("\nFor " + centsValue + " cents:");
        computeChange(centsValue);

        centsValue = 3;
        System.out.println("\nFor " + centsValue + " cents:");
        computeChange(centsValue);

        centsValue = 0;
        System.out.println("\nFor " + centsValue + " cents:");
        computeChange(centsValue);

        centsValue = -1;
        System.out.println("\nFor " + centsValue + " cents:");
        computeChange(centsValue);
    }
}