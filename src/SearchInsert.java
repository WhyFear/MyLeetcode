/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int i = 0;
        while (i < len && nums[i] < target) i++;
        return i;
    }
}
