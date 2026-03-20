package recursion;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sum(n, 0);

        System.out.println(sum1(3));
        System.out.println(fact(n));
    }

    // sum of first N numbers
    // parameterised recursive way
    static void sum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        sum (i - 1, sum + i);
    }

    // sum of first N numbers
    // functional recursive way
    // problem is broken down into subproblems

    static int sum1(int n) {
        if (n == 0) return 0;

        return n + sum1(n-1);
    }

    static int fact(int n) {
        if (n == 0) return 1;

        return n * fact(n - 1);
    }

    // We learnt, void recursive fn (ex - reverse array) and functional recursive function (ex - Palindrome String)
    // Multiple Recursion Calls

}
