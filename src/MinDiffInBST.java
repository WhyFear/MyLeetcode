/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinDiffInBST {
    int op = Integer.MAX_VALUE;
    int lastVal = -1;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return op;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (lastVal != -1) op = Math.min(op, Math.abs(root.val - lastVal));
        lastVal = root.val;
        dfs(root.right);
    }
}
