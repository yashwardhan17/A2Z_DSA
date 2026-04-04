package dp;

import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(robTabulation(arr));
    }

    // tabulation
    static int robTabulation(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    // recursive solution
    static int rob(int idx, int[] arr) {
        if (idx == 0) return arr[idx];
        if (idx < 0) return 0;

        int pick = arr[idx] + rob(idx - 2, arr);
        int notPick = 0 + rob(idx - 1, arr);

        return Math.max(pick, notPick);
    }

    // memoization
    static int robMemo(int idx, int[] arr, int[] dp) {
        if (idx == 0) return arr[idx];
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + robMemo(idx - 2, arr, dp);
        int notPick = robMemo(idx - 1, arr, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    static int robSpaceOptimized(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int pick = arr[i] + prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}
