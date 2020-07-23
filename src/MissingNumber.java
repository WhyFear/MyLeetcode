/**
 * https://leetcode-cn.com/problems/missing-number-lcci/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = ((len + 1) * (len)) / 2;
        for (int num : nums) sum -= num;
        return sum;
    }
}
