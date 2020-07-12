import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    public static int[] singleNumbers(int[] nums) {
        int[] op = new int[]{-1, -1};
        boolean first = true;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i] != nums[i + 1]) {
                if (first) {
                    op[0] = nums[i];
                    first = false;
                } else op[1] = nums[i];
                i++;
            } else {
                i += 2;
            }
        }
        if (op[1] == -1) op[1] = nums[nums.length - 1];
        return op;
    }
}
