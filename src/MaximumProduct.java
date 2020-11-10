import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * chaoxi
 * 蠢
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
