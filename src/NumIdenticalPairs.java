import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 * 排列组合两两配对的情况,公式是 (n * (n - 1)) / 2
 */
public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int op = 0;
        for (int key : map.keySet()) {
            int n = map.get(key);
            op += (n * (n - 1)) / 2;
        }
        return op;
    }
}
