/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Fib {
    public int fib(int N) {
        if (N < 1) return 0;
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
