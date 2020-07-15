/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * chaoxi
 */
public class Flatten {
    TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }
}
