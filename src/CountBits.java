/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int a = 1;
        for (int i = 1; i <= num; i++) {
            dp[i] = 1 + dp[i - (int) Math.pow(2, a - 1)];
            if (i + 1 == Math.pow(2, a)) a++;
        }
        return dp;
    }
}
