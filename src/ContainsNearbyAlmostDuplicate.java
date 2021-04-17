import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    /**
     * https://leetcode-cn.com/problems/contains-duplicate-iii/
     * 给你一个整数数组 nums 和两个整数 k 和 t 。
     * 请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，
     * 同时又满足 abs(i - j) <= k 。
     * 两个数值差距在t以内,距离差距在k以内.
     * chaoxi
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < len; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
