/**
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 * easy dp
 * 评论永远更牛逼
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int[] dp = new int[len];
        int increase = -1; //-1表示未设值，0表示递减，1表示递增。
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int dis = nums[i] - nums[i - 1];
            if (dis == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            if (increase == -1) {
                increase = dis > 0 ? 1 : 0;
                dp[i] = 1 + dp[i - 1];
            } else {
                if (increase == 0) {
                    if (dis < 0) dp[i] = dp[i - 1];
                    else {
                        dp[i] = dp[i - 1] + 1;
                        increase = 1 - increase;
                    }
                } else {
                    if (dis > 0) dp[i] = dp[i - 1];
                    else {
                        dp[i] = dp[i - 1] + 1;
                        increase = 1 - increase;
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
