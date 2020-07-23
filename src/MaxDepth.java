/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.right = new TreeNode(9);
        System.out.println(maxDepth(root));
    }

    public static int findMaxDepth(TreeNode root, int level) {
        if (root == null) return level;
        int levelLeft = 0, levelRight = 0;
        if (root.left != null) levelLeft = findMaxDepth(root.left, level + 1);
        if (root.right != null) levelRight = findMaxDepth(root.right, level + 1);
        return Math.max(levelLeft, levelRight) + 1; //灵魂
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return findMaxDepth(root, 0);
    }
}
