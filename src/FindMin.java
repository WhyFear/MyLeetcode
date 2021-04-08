/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMin {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        return min;
    }
}
