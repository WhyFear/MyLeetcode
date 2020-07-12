/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int op = 1;
        int tmp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                tmp++;
            } else {
                op = Math.max(op, tmp);
                tmp = 1;
            }
        }
        op = Math.max(op, tmp);
        return op;
    }
}
