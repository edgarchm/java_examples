package com.pure.java;

import java.security.SecureRandom;
import java.util.UUID;
public class RandomStringxLen {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom(); //Random RANDOM = new Random();
    public static void main(String[] args) {
        int length = 10; // Desired length of the random string
        String randomString1 = generateRandomString(length);
        System.out.println(randomString1);
        String randomString2 = randomAlphaNum_UUID(length);
        System.out.println(randomString2);
    }
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));//sb = sb+CHARACTERS.charAt(index)
        }
        return sb.toString();
    }
    public static String randomAlphaNum_UUID(int length){
        String sb = UUID.randomUUID().toString(); // Generates 36 char long UserIDs
        sb = sb.replace("-",""); //UIds have hypens
        return sb.substring(0,length);
    }
}
