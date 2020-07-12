import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[]{1, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 传入的数组已经有序
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int index = 0;
        int isOdd = (nums1.length + nums2.length) % 2;
        int half = (nums1.length + nums2.length) / 2;
        Stack<Integer> result = new Stack<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) result.push(nums1[i++]);
            else result.push(nums2[j++]);
            if (index == half) {
                if (isOdd == 1) return result.pop();
                else return (double) (result.pop() + result.pop()) / 2;
            }
            index++;
        }
        while (i < nums1.length) {
            result.push(nums1[i]);
            i++;
            if (index == half) {
                if (isOdd == 1) return result.pop();
                else return (double) (result.pop() + result.pop()) / 2;
            }
            index++;
        }
        while (j < nums2.length) {
            result.push(nums2[j]);
            j++;
            if (index == half) {
                if (isOdd == 1) return result.pop();
                else return (double) (result.pop() + result.pop()) / 2;
            }
            index++;
        }
        return 0;
    }
}
