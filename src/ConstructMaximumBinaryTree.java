/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = dfs(root, num);
        }
        return root;
    }

    private TreeNode dfs(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) { //节点值比val小，则节点在val的左侧
            TreeNode p = new TreeNode(val);
            p.left = root;
            return p;
        }
        root.right = dfs(root.right, val);

        return root;
    }
}
