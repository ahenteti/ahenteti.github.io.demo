package io.github.ahenteti.java.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

@FunctionalInterface
interface JavaLambdaExpressionsSolutionPerformOperation {
    boolean check(int a);
}

class JavaLambdaExpressionsSolutionMyMath {

    public JavaLambdaExpressionsSolutionPerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    public JavaLambdaExpressionsSolutionPerformOperation isPrime() {
        return n -> BigInteger.valueOf(n).isProbablePrime(1);
    }

    public JavaLambdaExpressionsSolutionPerformOperation isPalindrome() {
        return n -> {
            String original = Integer.toString(n);
            String reversed = new StringBuilder(original).reverse().toString();
            return original.equals(reversed);
        };
    }

    public boolean checker(JavaLambdaExpressionsSolutionPerformOperation op, int num) {
        return op.check(num);
    }
}

class JavaLambdaExpressionsSolutionMain {

    public static void main(String[] args) throws IOException {
        JavaLambdaExpressionsSolutionMyMath ob = new JavaLambdaExpressionsSolutionMyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        JavaLambdaExpressionsSolutionPerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
