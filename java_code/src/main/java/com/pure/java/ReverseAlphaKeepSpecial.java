package com.pure.java;

public class ReverseAlphaKeepSpecial {

    public static String reverseAlphaKeepSpecial(String input) {
        // 1. Convert the input string into a character array.
        char[] inputArray = input.toCharArray();
        // 2. Create a new character array of the same size.
        char[] reversedArray = new char[inputArray.length];
        // 5. Create a separate index for alphabetic characters.
        int reversedAlphaIndex = inputArray.length - 1;

        // 3. Iterate through the input array.
        for (int i = 0; i < inputArray.length; i++) {
            // 4. Place non-alphabetic characters in their original positions.
            if (!Character.isLetter(inputArray[i])) {
                reversedArray[i] = inputArray[i];
            }
        }

        // 6. Iterate through the input array again.
        for (int i = 0; i < inputArray.length; i++) {
            // 7. Place alphabetic characters in reverse order.
            if (Character.isLetter(inputArray[i])) {
                // Find next available position
                while (reversedAlphaIndex >= 0 && !Character.isLetter(reversedArray[reversedAlphaIndex])) {
                    reversedAlphaIndex--;
                }
                if (reversedAlphaIndex >= 0) {
                    reversedArray[reversedAlphaIndex] = inputArray[i];
                    reversedAlphaIndex--;
                }
            }
        }
        // 8. Convert the new array to a string and return.
        return new String(reversedArray);
    }

    public static void main(String[] args) {
        String test1 = "we@l*c&om^e#";
        String test2 = "a1b2c3d";
        String test3 = "12345";
        String test4 = "abc";
        String test5 = "@#$";
        String test6 = "test@123string";

        System.out.println("Test 1: " + reverseAlphaKeepSpecial(test1)); // Expected: em@o*c&le^w#
        System.out.println("Test 2: " + reverseAlphaKeepSpecial(test2)); // Expected: d1c2b3a
        System.out.println("Test 3: " + reverseAlphaKeepSpecial(test3)); // Expected: 12345
        System.out.println("Test 4: " + reverseAlphaKeepSpecial(test4)); // Expected: cba
        System.out.println("Test 5: " + reverseAlphaKeepSpecial(test5)); // Expected: @#$
        System.out.println("Test 6: " + reverseAlphaKeepSpecial(test6)); // Expected: gnirts@321tset
    }
}