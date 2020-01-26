package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;

public class JavaStaticInitializerBlockSolution {

    static boolean flag;
    static int B;
    static int H;

    static {
        Scanner in = new Scanner(System.in);
        B = in.nextInt();
        H = in.nextInt();
        flag = true;
        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
