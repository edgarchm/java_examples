package com.pure.java;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // Integer division
            int midValue = arr[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Return -1 if the target is not found
    }
    public static void main(String[] args) {
        int[] sortedList = {0, 4, 7, 13, 14, 25, 46, 47, 48, 59, 80, 99, 100};
        int numToLocate = 14;
        int result = binarySearch(sortedList, numToLocate);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the list");
        }
    }
}