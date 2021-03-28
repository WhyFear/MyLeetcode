import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    private List<Integer> treeList = new ArrayList<>();
    private int index = 0;

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            dfs(root.left);
        }
        treeList.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public int next() {
        return treeList.get(index++);
    }

    public boolean hasNext() {
        return index < treeList.size();
    }
}
