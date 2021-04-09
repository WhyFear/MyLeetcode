public class FindMin {
    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     */
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        return min;
    }

    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     * chaoxi
     */
    public int findMinII(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                right--;
        }
        return nums[left];
    }


}
