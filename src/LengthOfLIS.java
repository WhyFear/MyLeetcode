/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 根据题解的思路完成：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int op = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, dp[j] + 1);
                }
            }
            dp[i] = tempMax;
            op = Math.max(op, tempMax);
        }
        return op;
    }
}
