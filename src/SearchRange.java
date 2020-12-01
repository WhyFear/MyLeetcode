/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 二分查找
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int mid, i, j;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                i = mid;
                j = mid;
                while (i >= 0 && nums[i] == target) i--;
                while (j < len && nums[j] == target) j++;
                return new int[]{i + 1, j - 1};
            }
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
