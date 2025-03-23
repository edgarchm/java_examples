package com.pure.java;

//Bubble sort
public class BubbleSort {
	static boolean swapped = false;
	public static void main(String[] args) {
		int[] array = { 5, 2, 9, 1, 5, 6 };
		printArray(array, swapped);
		bubbleSort(array);
		printArray(array, swapped);
	}
	public static void printArray(int[] array, boolean status) {
		if (status) {
			System.out.println("Array after sorting:");
		} else {
			System.out.println("\nArray before sorting:");
		}
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
	public static void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (array[j] > array[j + 1]) { // Swap array[j] and array[j + 1]
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			// If no two elements were swapped in the inner loop, then the array is already sorted
			if (!swapped)
				break;
		}
	}
}