/**
 * https://leetcode-cn.com/problems/magic-index-lcci/
 */
public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) return i;
        }
        return -1;
    }
}
