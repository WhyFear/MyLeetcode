import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int num : nums) {
            if (temp.containsKey(num)) return true;
            else temp.put(num, 1);
        }
        return false;
    }
}
