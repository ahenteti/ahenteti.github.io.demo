package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class JavaSubstringComparisonsSolution {

    public static String getSmallestAndLargest(String s, int k) {
        SortedSet<String> sortedSubstrings = new TreeSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            sortedSubstrings.add(s.substring(i, i + k));
        }
        return sortedSubstrings.first() + "\n" + sortedSubstrings.last();
    }

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }
}
