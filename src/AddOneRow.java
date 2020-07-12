/**
 * https://leetcode-cn.com/problems/add-one-row-to-tree/submissions/
 */
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode p = new TreeNode(v);
            p.left = root;
            root = p;
        } else dfs(root, v, d, 1);
        return root;
    }

    public void dfs(TreeNode root, int v, int d, int level) {
        if (root == null) return;
        if (level == d - 1) {
            TreeNode p = new TreeNode(v);
            p.left = root.left;
            root.left = p;
            TreeNode q = new TreeNode(v);
            q.right = root.right;
            root.right = q;
            return;
        }
        dfs(root.left, v, d, level + 1);
        dfs(root.right, v, d, level + 1);
    }
}
