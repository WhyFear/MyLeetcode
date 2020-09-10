import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 题解里面的剪枝方法非常好：  if(i>start&&candidates[i]==candidates[i-1]) continue;
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> op = new ArrayList<>();
        if (candidates.length < 1) return op;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>(), op);
        return op;
    }

    private void dfs(int[] candidates, int target, int start, int sum, List<Integer> temp, List<List<Integer>> op) {
        if (sum == target) {
            if (!op.contains(temp))
                op.add(new ArrayList<>(temp));
            return;
        }
        if (start == candidates.length) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                temp.add(candidates[i]);
                dfs(candidates, target, i + 1, sum + candidates[i], temp, op);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
