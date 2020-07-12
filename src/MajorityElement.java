import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 投票算法比较好
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length / 2;
        Map<Integer, Integer> quantity = new HashMap<>();
        for (int num : nums) {
            if (!quantity.containsKey(num)) quantity.put(num, 1);
            else {
                int temp = quantity.get(num) + 1;
                if (temp > len) return num;
                quantity.put(num, temp);
            }
        }
        return 0;
    }
}
