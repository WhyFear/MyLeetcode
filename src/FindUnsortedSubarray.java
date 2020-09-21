import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);
        Arrays.sort(temp);
        int left = 0, right = len - 1;
        while (left < len && nums[left] == temp[left]) left++;
        while (right >= left && nums[right] == temp[right]) right--;
        if (left <= right) return right - left + 1;
        else return 0;
    }
}
