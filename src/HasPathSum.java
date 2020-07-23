/**
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {
    int sum;
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        if (root != null)
            dfs(root, 0);
        return flag;
    }

    private void dfs(TreeNode root, int tempSum) {
        tempSum += root.val;
        if (root.left == null && root.right == null) {
            if (tempSum == sum) {
                flag = true;
            }
            return;
        }

        if (root.left != null)
            dfs(root.left, tempSum);
        if (root.right != null)
            dfs(root.right, tempSum);
    }
}
