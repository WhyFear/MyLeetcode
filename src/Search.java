/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 1));
    }


    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == target) return i;
            if (nums[j] == target) return j;
            i++;
            j--;
        }
        return -1;
    }
}
