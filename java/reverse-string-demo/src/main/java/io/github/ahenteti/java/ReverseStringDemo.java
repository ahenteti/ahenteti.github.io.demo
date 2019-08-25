package io.github.ahenteti.java;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class ReverseStringDemo {
    public static void main(String[] args) {
        String randomString = generateRandomString(100000);
        String reversedString;
        StringBuilder reversedStringBuilder;
        long currentTime;

        // using string concatenation technique
        reversedString = "";
        currentTime = System.currentTimeMillis();
        for (int i = randomString.length() - 1; i >= 0; i--) {
            reversedString += randomString.charAt(i);
        }
        System.out.println(System.currentTimeMillis() - currentTime); // ~ 6000ms

        // using StringBuilder reverse method
        currentTime = System.currentTimeMillis();
        reversedStringBuilder = new StringBuilder(randomString);
        reversedString = reversedStringBuilder.reverse().toString();
        System.out.println(System.currentTimeMillis() - currentTime); // 10ms

        // using StringBuilder append method
        currentTime = System.currentTimeMillis();
        reversedStringBuilder = new StringBuilder();
        for (int i = randomString.length() - 1; i >= 0; i--) {
            reversedStringBuilder.append(randomString.charAt(i));
        }
        reversedString = reversedStringBuilder.toString();
        System.out.println(System.currentTimeMillis() - currentTime); // 2ms
    }

    private static String generateRandomString(int size) {
        byte[] array = new byte[size];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
