/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 滑动窗口
 * chaoxi
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        if (len == Integer.MAX_VALUE) {
            return 0;
        }
        return len;
    }
}
