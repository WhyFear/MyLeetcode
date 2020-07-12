import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 抄袭代码
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 3, 3, 3, -4};
//        int[] nums = new int[]{-3, 0, 1, -2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            } //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
     */
    public int maxProduct2(int[] nums) {
        int max = 0;
        int secondMax = 0;
        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return (max - 1) * (secondMax - 1);
    }
}
