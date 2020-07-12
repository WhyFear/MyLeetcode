/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {
    /**
     * dp,dp两次。
     * 从左到右的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int[] op = new int[nums.length];
        int[] fromLeftToRight = new int[nums.length];
        fromLeftToRight[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            fromLeftToRight[i] = nums[i - 1] * fromLeftToRight[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            op[i] = fromLeftToRight[i] * temp;
            temp = nums[i] * temp;
        }
        return op;
    }

    /**
     * 不符合题意（使用了除法）
     */
    public int[] productExceptSelfVer1(int[] nums) {
        int result = 1;
        int zeroQuan = 0;
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) result = result * num;
            else {
                zeroQuan++;
                zeroIndex = i;
            }
        }
        if (zeroQuan != 0) {
            if (zeroQuan >= 2) return new int[nums.length];
            else {
                int[] op = new int[nums.length];
                op[zeroIndex] = result;
                return op;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result / nums[i];
        }
        return nums;
    }
}
