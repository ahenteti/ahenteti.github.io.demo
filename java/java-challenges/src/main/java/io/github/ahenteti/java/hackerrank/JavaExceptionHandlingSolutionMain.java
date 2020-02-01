package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;

class JavaExceptionHandlingSolutionCalculator {

    public int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) throw new Exception("n or p should not be negative.");
        if (n == 0 && p == 0) throw new Exception("n and p should not be zero.");
        return (int) Math.pow(n, p);
    }
}

public class JavaExceptionHandlingSolutionMain {

    public static final JavaExceptionHandlingSolutionCalculator calculator = new JavaExceptionHandlingSolutionCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
