import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class CombinationSum3 {
    List<List<Integer>> op;

    public List<List<Integer>> combinationSum3(int k, int n) {
        op = new ArrayList<>();
        dfs(k, n, 0, new ArrayList<>(), 0, 1);
        return op;
    }

    private void dfs(int k, int n, int level, List<Integer> sumList, int sum, int start) {
        if (level == k) {
            if (sum == n)
                op.add(new ArrayList<>(sumList));
            return;
        }
        if ((n - sum) > 9 * (k - level) || sum >= n) return; //剪剪剪~枝
        for (int i = start; i < 10; i++) {
            sumList.add(i);
            dfs(k, n, level + 1, sumList, sum + i, i + 1);
            sumList.remove(level);
        }
    }
}
