/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class IsCousins {
    int xFather, yFather, xLevel, yLevel;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, -1, x, y, 0);
        return xFather != yFather && xLevel == yLevel;
    }

    private void dfs(TreeNode root, int parent, int x, int y, int level) {
        if (root == null) return;
        if (root.val == x) {
            xFather = parent;
            xLevel = level;
        } else if (root.val == y) {
            yFather = parent;
            yLevel = level;
        }
        dfs(root.left, root.val, x, y, level + 1);
        dfs(root.right, root.val, x, y, level + 1);
    }
}
