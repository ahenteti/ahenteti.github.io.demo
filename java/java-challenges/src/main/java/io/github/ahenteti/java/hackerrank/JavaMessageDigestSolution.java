package io.github.ahenteti.java.hackerrank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMessageDigestSolution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        String valueToEncrypt = in.next();
        in.close();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(valueToEncrypt.getBytes());
        for (byte b : hash) System.out.printf("%02x", b);
        System.out.println();
    }
}
