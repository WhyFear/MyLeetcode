/**
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = (int)Math.pow(10,i) - dp[i - 1] - 9;
        }
        return dp[n];
    }
}
