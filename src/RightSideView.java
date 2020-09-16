import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        if (root == null) return op;
        dfs(root, 0, op);
        return op;
    }

    private void dfs(TreeNode root, int level, List<Integer> op) {
        if (root == null) return;
        if (level == op.size()) op.add(root.val);
        else op.set(level, root.val);
        dfs(root.left, level + 1, op);
        dfs(root.right, level + 1, op);
    }
}
