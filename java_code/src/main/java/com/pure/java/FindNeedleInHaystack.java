package com.pure.java;

public class FindNeedleInHaystack {
    /**
     * Finds the index of the first occurrence of a needle in a haystack.
     *
     * @param haystack The string to search in.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if needle is not found.
     */
    public static int findNeedleInHaystack(String haystack, String needle) {
        // If the needle is an empty string, it's considered found at the beginning
        if (needle.isEmpty()) {
            return 0;
        }

        // Use the indexOf method to find the first occurrence of the needle in the haystack
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        // Example usage:

        String haystack1 = "hello world";
        String needle1 = "world";
        int index1 = findNeedleInHaystack(haystack1, needle1);
        System.out.println("Index of '" + needle1 + "' in '" + haystack1 + "': " + index1);

        String haystack2 = "hello world";
        String needle2 = "Hello";
        int index2 = findNeedleInHaystack(haystack2, needle2);
        System.out.println("Index of '" + needle2 + "' in '" + haystack2 + "': " + index2);

        String haystack3 = "hello world";
        String needle3 = "";
        int index3 = findNeedleInHaystack(haystack3, needle3);
        System.out.println("Index of '" + needle3 + "' in '" + haystack3 + "': " + index3);

        String haystack4 = "mississippi";
        String needle4 = "issi";
        int index4 = findNeedleInHaystack(haystack4, needle4);
        System.out.println("Index of '" + needle4 + "' in '" + haystack4 + "': " + index4);

        String haystack5 = "aaaaa";
        String needle5 = "bba";
        int index5 = findNeedleInHaystack(haystack5, needle5);
        System.out.println("Index of '" + needle5 + "' in '" + haystack5 + "': " + index5);
    }
}

