import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        if (root == null) return op;
        dfs(root, op);
        return op;
    }

    private void dfs(TreeNode root, List<Integer> op) {
        if (root == null) return;
        dfs(root.left, op);
        dfs(root.right, op);
        op.add(root.val);
    }
}
