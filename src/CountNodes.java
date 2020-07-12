/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class CountNodes {
    int op;

    public int countNodes(TreeNode root) {
        dfs(root);
        return op;
    }
    private void dfs(TreeNode root){
        if (root==null) return;
        op++;
        dfs(root.left);
        dfs(root.right);
    }
}
