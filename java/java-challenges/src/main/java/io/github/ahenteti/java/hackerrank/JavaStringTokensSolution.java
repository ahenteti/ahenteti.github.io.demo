package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;

public class JavaStringTokensSolution {

    public static void main(String[] args) {
        String s = null;
        s = s.trim();
        if (s.length() == 0) {
            System.out.println("0");
            return;
        }
        String[] segments = s.split("[ !,?._'@]+");
        System.out.println(segments.length);
        for (int i = 0; i < segments.length; i++) {
            System.out.println(segments[i]);
        }
    }
}
