/**
 * https://leetcode-cn.com/problems/predict-the-winner/
 * chaoxi
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) return true;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
