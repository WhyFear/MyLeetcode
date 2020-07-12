import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 本题考验对异或的用法，相同为零，相异为一。具体参考：https://leetcode-cn.com/problems/single-number/comments/42235
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int num : nums) {
            if (temp.containsKey(num)) {
                temp.remove(num);
            } else
                temp.put(num, 1);
        }
        for (int key : temp.keySet()) {
            if (temp.get(key) == 1)
                return key;
        }
        return 0;
    }
}
