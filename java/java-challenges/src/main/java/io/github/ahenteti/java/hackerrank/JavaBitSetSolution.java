package io.github.ahenteti.java.hackerrank;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSetSolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet[] bitSets = {new BitSet(n), new BitSet(n)};
        for (int i = 0; i < m; i++) {
            String operation = in.next();
            int set1;
            int set2;
            int set;
            int setIndex;
            switch (operation) {
                case "AND":
                    set1 = in.nextInt() - 1;
                    set2 = in.nextInt() - 1;
                    bitSets[set1].and(bitSets[set2]);
                    break;
                case "OR":
                    set1 = in.nextInt() - 1;
                    set2 = in.nextInt() - 1;
                    bitSets[set1].or(bitSets[set2]);
                    break;
                case "XOR":
                    set1 = in.nextInt() - 1;
                    set2 = in.nextInt() - 1;
                    bitSets[set1].xor(bitSets[set2]);
                    break;
                case "FLIP":
                    set = in.nextInt() - 1;
                    setIndex = in.nextInt();
                    bitSets[set].flip(setIndex);
                    break;
                case "SET":
                    set = in.nextInt() - 1;
                    setIndex = in.nextInt();
                    bitSets[set].set(setIndex);
                    break;
            }
            System.out.println(String.format("%d %d", bitSets[0].cardinality(), bitSets[1].cardinality()));
        }
    }
}
