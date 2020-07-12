import java.util.*;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 */
public class Pick {
    private final Map<Integer, List<Integer>> op;

    public Pick(int[] nums) {
        op = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (op.containsKey(num)) {
                List<Integer> temp = op.get(num);
                temp.add(i);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                op.put(num, tmp);
            }
        }
    }

    public int pick(int target) {
        List<Integer> temp = op.get(target);
        Random r = new Random();
        return op.get(target).get(r.nextInt(temp.size()));
    }
}
