import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/submissions/
 * chaoxi
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int op = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(op - target)) {
                    op = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }
            }
        }
        return op;
    }
}
