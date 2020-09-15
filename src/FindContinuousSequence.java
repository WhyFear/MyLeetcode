import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 这返回值就离谱
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> op = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            dfs(target, i + 1, temp, i, op);
        }
        List<int[]> tmp = new ArrayList<>();
        for (List<Integer> ttemp : op) {
            int[] fuck = new int[ttemp.size()];
            for (int i = 0; i < ttemp.size(); i++) fuck[i] = ttemp.get(i);
            tmp.add(fuck);
        }
        return tmp.toArray(new int[tmp.size()][]);
    }

    private void dfs(int target, int index, List<Integer> temp, int sum, List<List<Integer>> op) {
        if (index == target || sum > target) {
            return;
        }
        if (sum == target) {
            op.add(new ArrayList<>(temp));
            return;
        }
        temp.add(index);
        dfs(target, index + 1, temp, sum + index, op);
    }
}
