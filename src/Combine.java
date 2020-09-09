import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> op = new ArrayList<>();
        if (k == 0) return op;
        dfs(n, 1, k, new ArrayList<>(), op);
        return op;
    }

    private void dfs(int n, int index, int k, List<Integer> temp, List<List<Integer>> op) {
        if (k == 0) {
            op.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            dfs(n, i + 1, k - 1, temp, op);
            temp.remove(temp.size() - 1);
        }
    }
}
