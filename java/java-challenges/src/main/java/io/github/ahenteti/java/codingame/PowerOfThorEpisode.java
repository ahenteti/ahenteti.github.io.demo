package io.github.ahenteti.java.codingame;

import java.util.Scanner;

/**
 * Hello world!
 */
public class PowerOfThorEpisode {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        if (n == 0) {
            System.out.println("0");
            return;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if (Math.abs(t) < Math.abs(result)) {
                result = t;
            }
            if (Math.abs(t) == Math.abs(result)) {
                result = Math.max(t, result);
            }
        }
        System.out.println(result);
    }
}
