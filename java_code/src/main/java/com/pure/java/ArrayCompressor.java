package com.pure.java;

import java.awt.*;
public class ArrayCompressor {

    public static List compressArray(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new List();
        }

        List compressed = new List();
        String currentElement = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(currentElement)) {
                count++;
            } else {
                compressed.add(currentElement);
                compressed.add(String.valueOf(count));
                currentElement = arr[i];
                count = 1;
            }
        }

        compressed.add(currentElement);
        compressed.add(String.valueOf(count));
        return compressed;
    }

    public static void main(String[] args) {
        String[] sampleArray = {"a", "a", "b", "a", "b", "b", "a", "a", "a"};
        List compressedArray = compressArray(sampleArray);
        System.out.println(compressedArray); // Output: [a, 2, b, 1, a, 1, b, 2, a, 3]

        String[] sampleArray2 = {"a","a","b","a","b","b"};
        List compressedArray2 = compressArray(sampleArray2);
        System.out.println(compressedArray2); // Output: [a, 2, b, 1, a, 1, b, 2]

        String[] sampleArray3 = {"a","a","a","b","b"};
        List compressedArray3 = compressArray(sampleArray3);
        System.out.println(compressedArray3); // Output: [a, 3, b, 2]
    }
}
