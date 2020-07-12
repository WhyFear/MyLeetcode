import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }

    /**
     * 暴力
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        return result;
    }

    /**
     * 使用hash
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toBeFind = target - nums[i];
            if (temp.containsKey(toBeFind)) {
                result[0] = temp.get(toBeFind);
                result[1] = i;
                return result;
            }
            temp.put(nums[i], i);
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
     * 本题有序，应有更优解
     */
    public int[] twoSum(int[] nums, int target) {
        int[] op = new int[2];
        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if (temp.contains(target - num)) {
                op[0] = num;
                op[1] = target - num;
                break;
            }
            temp.add(num);
        }
        return op;
    }
}