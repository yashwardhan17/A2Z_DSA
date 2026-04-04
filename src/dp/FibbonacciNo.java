package dp;

import java.util.Arrays;
import java.util.Scanner;

public class FibbonacciNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1]; // declaration
        Arrays.fill(dp, -1);
        System.out.println(fib2(n, dp));
    }

    static int fib(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n]; // check if the problem has already been solved
        return dp[n] = fib(n-1, dp) + fib(n-2, dp); // store computed values in dp array
    }

    static int fib2(int n, int[] dp) {
        if (n <= 1) return n;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    static int fib3(int n) {
        if (n <= 1) return n;
        int prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
