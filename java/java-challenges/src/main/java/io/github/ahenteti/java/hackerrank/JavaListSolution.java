package io.github.ahenteti.java.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaListSolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<Integer> list = arrayFromString(in.nextLine());
        int q = in.nextInt();
        while (q-- > 0) {
            String op = in.next();
            switch (op) {
                case "Insert":
                    int x1 = in.nextInt();
                    int y1 = in.nextInt();
                    list.add(x1, y1);
                    break;
                case "Delete":
                    int x2 = in.nextInt();
                    list.remove(x2);
                    break;
                default:
                    throw new RuntimeException("Unknown operation: " + op);
            }
        }
        System.out.println(toString(list));
    }

    private static String toString(List<Integer> list) {
        if (list.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(" ");
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private static List<Integer> arrayFromString(String arrayString) {
        String[] splitRes = arrayString.split(" ");
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < splitRes.length; i++) {
            res.add(Integer.parseInt(splitRes[i]));
        }
        return res;
    }
}
