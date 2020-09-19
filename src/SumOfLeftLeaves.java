/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
    int op = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return op;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) op += root.left.val;
        else dfs(root.left);
        dfs(root.right);
    }
}
