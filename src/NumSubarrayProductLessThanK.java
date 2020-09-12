/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * chaoxi
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int sum = 1, op = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (sum >= k) sum /= nums[left++];
            op += right - left + 1;
        }
        return op;
    }
}
