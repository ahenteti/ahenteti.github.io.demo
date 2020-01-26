package io.github.ahenteti.java.hackerrank;

public class StrongPasswordSolution {

    static int minimumNumber(int n, String password) {
        int res = 0;
        if (!atLeastOneDigit(password)) res++;
        if (!atLeastOneLowercaseEnglishChar(password)) res++;
        if (!atLeastOneUppercaseEnglishChar(password)) res++;
        if (!atLeastOneSpecialChar(password)) res++;
        return Math.max(atLeastSixChar(n), res);
    }

    private static int atLeastSixChar(int n) {
        return Math.max(0, 6 - n);
    }

    private static boolean atLeastOneDigit(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }

    private static boolean atLeastOneLowercaseEnglishChar(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }

    private static boolean atLeastOneUppercaseEnglishChar(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    private static boolean atLeastOneSpecialChar(String password) {
        return password.chars().anyMatch(c -> "!@#$%^&*()-+".indexOf(c) >= 0);
    }

    public static void main(String[] args) {
        System.out.println(minimumNumber(8, "$%-(%)(%"));
    }
}
