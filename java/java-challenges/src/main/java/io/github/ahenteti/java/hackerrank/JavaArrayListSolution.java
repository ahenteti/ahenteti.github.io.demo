package io.github.ahenteti.java.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArrayListSolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = in.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                a.add(in.nextInt());
            }
            array.add(a);
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            try {
                System.out.println(array.get(x).get(y));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
    }
}
