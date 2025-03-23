package com.others;

//package com;
public class DateMonthWordsDayOrdinalYearWords {

    private static final String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String dateMonthWordsDayOrdinalYearWords(String date) {
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        String monthName = months[month - 1];
        String dayOrdinal = getOrdinal(day);
        String yearWords = numberToWords(year);

        return monthName + " " + dayOrdinal + ", " + yearWords;
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

    private static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private static String helper(int num) {
        String result = "";
        if (num < 20) {
            result = units[num];
        } else if (num < 100) {
            result = tens[num / 10] + ((num % 10 != 0) ? " " : "") + units[num % 10];
        } else if (num < 1000) {
            result = units[num / 100] + " Hundred" + ((num % 100 != 0) ? " " : "") + helper(num % 100);
        } else if (num < 1000000) {
            result = helper(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " " : "") + helper(num % 1000);
        } else if (num < 1000000000) {
            result = helper(num / 1000000) + " Million" + ((num % 1000000 != 0) ? " " : "") + helper(num % 1000000);
        } else {
            result = helper(num / 1000000000) + " Billion" + ((num % 1000000000 != 0) ? " " : "") + helper(num % 1000000000);
        }
        return result.trim();
    }

    public static void main(String[] args) {
        String[] test = {"03/16/2024", "12/25/1999", "01/01/0001", "10/31/2000"};
        System.out.println("Test 1: " + dateMonthWordsDayOrdinalYearWords(test[0])); // Expected output: March 16th, Two Thousand Twenty Four
        System.out.println("Test 2: " + dateMonthWordsDayOrdinalYearWords(test[1])); // Expected output: December 25th, One Thousand Nine Hundred Ninety Nine
        System.out.println("Test 3: " + dateMonthWordsDayOrdinalYearWords(test[2])); // Expected output: January 1st, One
        System.out.println("Test 4: " + dateMonthWordsDayOrdinalYearWords(test[3])); // Expected output: October 31st, Two Thousand
    }
}