import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        int op = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if(i >= 1 && nums[i] == nums[i -1]) continue;
            for (int j = len - 1; j > i; j--) {
                int dis = nums[j] - nums[i];
                if (dis == k) {
                    op++;
                } else if (dis < k) break;
                while (j > i && nums[j - 1] == nums[j]) j--;
            }
        }
        return op;
    }
}
