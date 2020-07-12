import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int item : nums1) {
            if (!nums1Map.containsKey(item))
                nums1Map.put(item, 1);
            else nums1Map.put(item, nums1Map.get(item) + 1);
        }
        List<Integer> op = new ArrayList<>();
        for (int value : nums2) {
            if (nums1Map.containsKey(value)) {
                op.add(value);
                int count = nums1Map.get(value);
                if (count == 1) nums1Map.remove(value);
                else nums1Map.put(value, count - 1);
            }
        }
        int[] res = new int[op.size()];
        for (int i = 0; i < op.size(); i++) {
            res[i] = op.get(i);
        }
        return res;
    }
}
/*
精彩代码赏析
class Solution {
   public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        // 可以换成自带的排序函数
        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);
        int index = 0;
        int[] res = new int[nums1.length];
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int mid = left + (right - left) / 2;
            int temp = nums[mid];
            nums[mid] = nums[left];
            nums[left] = temp;
            int pivot = nums[left];
            while (l < r) {
                while (l < r && nums[r] >= pivot) {
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }
                while (l < r && nums[l] < pivot) {
                    l++;
                }
                if (l < r) {
                    nums[r--] = nums[l];
                }
            }
            nums[l] = pivot;
            quickSort(nums, left, l - 1);
            quickSort(nums, l + 1, right);
        }
    }
}
 */