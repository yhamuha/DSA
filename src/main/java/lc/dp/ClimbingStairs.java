package lc.dp;

public class ClimbingStairs {
    // O(n)
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        var cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(5));
    }
}
