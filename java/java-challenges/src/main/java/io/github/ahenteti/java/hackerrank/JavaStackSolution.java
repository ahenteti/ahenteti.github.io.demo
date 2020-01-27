package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class JavaStackSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            if (isBalancedParentheses(sc.next())) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }

    private static boolean isBalancedParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                String parenthesesCouple = "" + stack.peek() + c;
                switch (parenthesesCouple) {
                    case "{}":
                    case "()":
                    case "[]":
                        stack.pop();
                        break;
                    default:
                        stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
