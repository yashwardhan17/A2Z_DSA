package dp;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        System.out.println(climbStairs(n, dp));
    }

    // Tabulation
    static int climbStairs(int n, int[] dp) {
        dp[0] = 1; // Base case: 1 way to climb 0 stairs (do nothing)
        dp[1] = 1; // Base case: 1 way to climb 1 stair (take one step)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Space Optimized
    static int climbStairs2(int n) {
        if (n <= 1) return 1;
        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // Memoization
    static int climbStairsMemo(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != -1) return dp[n]; // already computed
        dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
        return dp[n];
    }
}
