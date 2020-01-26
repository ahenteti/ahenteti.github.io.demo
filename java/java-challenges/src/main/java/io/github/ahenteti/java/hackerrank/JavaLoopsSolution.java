package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;

public class JavaLoopsSolution {


    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += (int) Math.pow(2, j) * b;
                arr[j] = sum;
            }
            StringBuilder out = new StringBuilder();
            for (int j = 0; j < n - 1; j++) {
                out.append(a + arr[j]);
                out.append(" ");
            }
            out.append(a + arr[n - 1]);
            System.out.println(out);
        }
        in.close();
    }
}
