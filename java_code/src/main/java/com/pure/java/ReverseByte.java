package com.pure.java;

public class ReverseByte {

    public static byte reverseByte(byte b) {
        int value = b & 0xFF; // Convert byte to unsigned integer
        int reversedValue = 0;

        for (int i = 0; i < 8; i++) {
            reversedValue = (reversedValue << 1) | ((value >> i) & 1);
        }

        return (byte) reversedValue; // Convert back to byte
    }

    public static String toBinaryString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    public static void main(String[] args) {
        byte byteToReverse = (byte) 0b10101100; // Example byte (172 in decimal)
        byte reversedByte = reverseByte(byteToReverse);
        System.out.println("Original byte: " + toBinaryString(byteToReverse));
        System.out.println("Reversed byte: " + toBinaryString(reversedByte));

        byteToReverse = (byte) 0b00000001;
        reversedByte = reverseByte(byteToReverse);
        System.out.println("Original byte: " + toBinaryString(byteToReverse));
        System.out.println("Reversed byte: " + toBinaryString(reversedByte));

        byteToReverse = (byte) 0b10000000;
        reversedByte = reverseByte(byteToReverse);
        System.out.println("Original byte: " + toBinaryString(byteToReverse));
        System.out.println("Reversed byte: " + toBinaryString(reversedByte));

        byteToReverse = (byte) 0b11111111;
        reversedByte = reverseByte(byteToReverse);
        System.out.println("Original byte: " + toBinaryString(byteToReverse));
        System.out.println("Reversed byte: " + toBinaryString(reversedByte));

        byteToReverse = (byte) 0b00000000;
        reversedByte = reverseByte(byteToReverse);
        System.out.println("Original byte: " + toBinaryString(byteToReverse));
        System.out.println("Reversed byte: " + toBinaryString(reversedByte));
    }
}