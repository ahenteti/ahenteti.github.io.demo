package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;

public class ValidUsernameRegularExpressionSolution {

    private static final String USERNAME_PATTERN = "[a-zA-Z][a-zA-Z0-9_]{7,29}";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(USERNAME_PATTERN)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
