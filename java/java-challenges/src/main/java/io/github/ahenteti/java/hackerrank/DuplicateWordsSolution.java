package io.github.ahenteti.java.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWordsSolution {

    public static void main(String[] args) {
        String regex = "\\b(\\w+)(:?\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String input = "Goodbye bye bye world world world";
        Matcher m = p.matcher(input);
        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(1));
        }
        System.out.println(input);
    }
}
