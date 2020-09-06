import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        if (root == null) return op;
        Deque<TreeNode> treeStack = new ArrayDeque<>();
        Deque<Integer> levelStack = new ArrayDeque<>();
        treeStack.push(root);
        levelStack.push(1);
        while (!treeStack.isEmpty()) {
            TreeNode p = treeStack.pollLast();
            int level = levelStack.pollLast();
            if (level > op.size()) {
                List<Integer> temp = new ArrayList<>();
                temp.add(p.val);
                op.add(temp);
            } else op.get(level - 1).add(p.val);
            if (p.left != null) {
                treeStack.push(p.left);
                levelStack.push(level + 1);
            }
            if (p.right != null) {
                treeStack.push(p.right);
                levelStack.push(level + 1);
            }
        }
        Collections.reverse(op);
        return op;
    }
}
