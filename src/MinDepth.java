public class MinDepth {
    int op = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return op;
    }

    private void dfs(TreeNode root, int level) {
        if (root.right == null && root.left == null) {
            op = Math.min(op, level);
            return;
        }
        if (root.left != null) dfs(root.left, level + 1);
        if (root.right != null) dfs(root.right, level + 1);
    }
}
