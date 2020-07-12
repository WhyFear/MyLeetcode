import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndex.containsKey(nums[i])) {
                if (Math.abs(i - numIndex.get(nums[i])) <= k) return true;
            }
            numIndex.put(nums[i], i);
        }
        return false;
    }
}
