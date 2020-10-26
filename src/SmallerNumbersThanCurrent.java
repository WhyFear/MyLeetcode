import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] temps = Arrays.copyOfRange(nums, 0, len);
        Arrays.sort(temps);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && temps[i] == temps[i - 1])
                continue;
            index.put(temps[i], i);
        }
        int[] op = new int[len];
        for (int i = 0; i < len; i++) {
            op[i] = index.get(nums[i]);
        }
        return op;
    }
}
