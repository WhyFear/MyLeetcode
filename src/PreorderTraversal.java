import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<Integer>();
        if (root == null) return op;
        dfs(root, op);
        return op;
    }

    private void dfs(TreeNode root, List<Integer> op) {
        if (root == null) return;
        op.add(root.val);
        dfs(root.left, op);
        dfs(root.right, op);
    }
}
