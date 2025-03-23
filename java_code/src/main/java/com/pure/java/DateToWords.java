package com.pure.java;

public class DateToWords {

    private static final String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    public static String dateToWords(String date) {
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        String monthName = months[month - 1];
        String dayOrdinal = getOrdinal(day);
        String yearNumber = Integer.toString(year);

        return monthName + " " + dayOrdinal + ", " + yearNumber;
    }

    private static String getOrdinal(int day) {
        if (day >= 11 && day <= 13) {
            return day + "th";
        }
        switch (day % 10) {
            case 1:
                return day + "st";
            case 2:
                return day + "nd";
            case 3:
                return day + "rd";
            default:
                return day + "th";
        }
    }

    public static void main(String[] args) {
        String[] test = {"03/16/2024", "12/25/1999", "01/01/0001", "10/31/2000"};
        System.out.println("Test 1: " + dateToWords(test[0])); // Expected output: March 16th, 2024
        System.out.println("Test 2: " + dateToWords(test[1])); // Expected output: December 25th, 1999
        System.out.println("Test 3: " + dateToWords(test[2])); // Expected output: January 1st, 1
        System.out.println("Test 4: " + dateToWords(test[3])); // Expected output: October 31st, 2000
    }
}
