/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        dfs(root, val);
        return root;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            dfs(root.right, val);
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            dfs(root.left, val);
        }
    }
}
