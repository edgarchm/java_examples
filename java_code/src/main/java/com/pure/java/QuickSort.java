package com.pure.java;//Quick Sort - Divide and Conquer
//Divides an array in equal parts and sorts each parts RECURSIVELY
//Once parts are sorted, they are combined

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {// Method to perform com.pure.java.QuickSort on an array
        if (low < high) {// Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); // Recursively sort elements before partition
            quickSort(arr, pivotIndex + 1, high);// Recursively sort elements after partition
        }
    }
    
    private static int partition(int[] arr, int low, int high) { // Method to partition the array and return the pivot index
        int pivot = arr[high]; // Choose the pivot (here, we choose the last element as the pivot)
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) { // If the current element is less than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; // Swap arr[i] and arr[j]
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; // Swap arr[i+1] and arr[high] (or pivot)
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    public static void main(String[] args) { // Main method to test com.pure.java.QuickSort
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
