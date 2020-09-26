import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> op = new ArrayList<>();
        if (root == null) return op;
        dfs(root, sum, 0, new ArrayList<>(), op);
        return op;
    }

    private void dfs(TreeNode root, int target, int sum, List<Integer> path, List<List<Integer>> op) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += root.val;
            path.add(root.val);
            if (sum == target) op.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        dfs(root.left, target, sum + root.val, path, op);
        dfs(root.right, target, sum + root.val, path, op);
        path.remove(path.size() - 1);
    }
}
