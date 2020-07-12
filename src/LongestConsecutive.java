import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 字节面试官思路：hash，每次hash时判断左右是否有值。如hash(4),hash(3),hash(5)以此类推
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * 不符合要求
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int op = 1;
        int tmp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (i == nums.length - 1) {
                    break;
                }
            } else if (nums[i] == nums[i + 1] - 1) {
                tmp++;
            } else {
                op = Math.max(op, tmp);
                tmp = 1;
            }
        }
        op = Math.max(op, tmp);
        return op;
    }

    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        int op = 0;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int num : nums) {
            if (!temp.containsKey(num)) {
                int left = 0;
                if (temp.containsKey(num - 1)) left = temp.get(num - 1);
                int right = 0;
                if (temp.containsKey(num + 1)) right = temp.get(num + 1);

                int numLen = 1 + left + right;
                op = Math.max(op, numLen);
                temp.put(num, numLen);
                //更新区间两端点的长度值, 如果hash表内有值则不需要处理，所以中间的值不用更新
                temp.put(num - left, numLen);
                temp.put(num + right, numLen);
            }
        }
        return op;
    }
}
