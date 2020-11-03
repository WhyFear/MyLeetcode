import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/set-mismatch/
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int[] counter = new int[nums.length + 1];

        for (int i : nums) {
            counter[i]++;
        }

        int[] result = new int[2];
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] == 0) {
                result[1] = i;
            } else if (counter[i] == 2) {
                result[0] = i;
            }
        }

        return result;
    }
}
