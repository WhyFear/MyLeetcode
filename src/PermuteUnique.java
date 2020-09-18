import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        if (nums.length < 1) return op;
        dfs(nums, new HashSet<>(), new ArrayList<>(), op);
        return op;
    }

    private void dfs(int[] nums, Set<Integer> set, List<Integer> temp, List<List<Integer>> op) {
        if (set.size() == nums.length) {
            if (!op.contains(temp))
                op.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                temp.add(nums[i]);
                set.add(i);
                dfs(nums, set, temp, op);
                set.remove(i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
