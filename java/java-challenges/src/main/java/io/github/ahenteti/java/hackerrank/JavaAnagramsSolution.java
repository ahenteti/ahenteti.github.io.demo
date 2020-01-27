package io.github.ahenteti.java.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaAnagramsSolution {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            map.computeIfAbsent(c, x -> 0);
            map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            Integer frequency = map.get(c);
            if (frequency == null || frequency == 0) return false;
            map.put(c, frequency - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
