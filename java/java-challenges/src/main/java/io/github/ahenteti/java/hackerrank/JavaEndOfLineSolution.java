package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;

public class JavaEndOfLineSolution {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (in.hasNext()) {
            i++;
            System.out.println(i + " " + in.nextLine());
        }
    }
}
