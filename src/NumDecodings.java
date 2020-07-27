/**
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0') dp[i] = dp[i - 1];
            int subStr = Integer.parseInt(s.substring(i - 1, i + 1));
            if (subStr >= 10 && subStr <= 26) {
                if (i == 1) dp[i]++;
                else dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}
