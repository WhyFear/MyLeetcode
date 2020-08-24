/**
 * 汇顶科技 2020-08-24 笔试题
 * 一头猪从出生后第三年起每年生一头小猪,小猪也是三年起每年生一头小猪.
 * 5年后5头 10年后55头 13年后233头
 */
public class GetPigCount {
    public int getPipCount(int n) {
        // write code here
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
