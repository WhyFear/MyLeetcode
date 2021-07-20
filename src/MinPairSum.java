import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
 *
 */
public class MinPairSum {
    public int minPairSum(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int min = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            min = Math.max(min, nums[left] + nums[right]);
            left++;
            right--;
        }
        return min;
    }
}
