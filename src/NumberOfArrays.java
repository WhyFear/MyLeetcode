/**
 * https://leetcode-cn.com/problems/restore-the-array/
 * 自己写的版本（dfs）超时
 * chaoxi
 */
public class NumberOfArrays {
    int MOD = 1000000007;

    public int numberOfArrays(String s, int k) {
        int len = s.length();
        char[] cs = s.toCharArray();
        long[] dp = new long[len + 1];
        dp[len] = 1;

        for (int i = len - 1; i >= 0; i--) {
            if (cs[i] == '0') continue;

            long tmp = 0;
            for (int j = i; j < len; j++) {
                tmp = tmp * 10 + cs[j] - '0';
                if (tmp <= k) {
                    dp[i] += dp[j + 1];
                } else {
                    break;
                }
            }

            dp[i] %= MOD;
        }
        return (int) dp[0];
    }
}
