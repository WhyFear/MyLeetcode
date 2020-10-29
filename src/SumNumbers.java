/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class SumNumbers {
    int op = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return op;
    }

    private void dfs(TreeNode root, int sum) {
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            op += sum;
            return;
        }
        if (root.left != null)
            dfs(root.left, sum);
        if (root.right != null)
            dfs(root.right, sum);
    }
}
