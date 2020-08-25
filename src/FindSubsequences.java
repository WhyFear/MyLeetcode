import java.util.*;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences/
 */
public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        for (int num : nums) {
            int opSize = op.size();
            for (int i = 0; i < opSize; i++) {
                List<Integer> temp = op.get(i);
                int len = temp.size();
                if (num >= temp.get(len - 1)) {
                    op.add(new ArrayList<>(temp));
                    temp.add(num);
                }
            }
            op.add(new ArrayList<>() {{
                add(num);
            }});
        }
        int size = op.size();
        for (int i = size - 1; i >= 0; i--) { // 去除单个的list
            if (op.get(i).size() == 1) {
                op.remove(i);
            }
        }
        Set<List<Integer>> fuck = new HashSet<>(op); // 去重
        return new ArrayList<>(fuck);
    }
}
/*
dfs超时
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), op);
        return op;
    }

    private void dfs(int[] nums, int start, List<Integer> temp, List<List<Integer>> op) {
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (temp.isEmpty() || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                if (temp.size() > 1 && !op.contains(temp))
                    op.add(new ArrayList<>(temp));
                dfs(nums, i + 1, temp, op);
                temp.remove(temp.size() - 1);
            }
        }
    }
 */