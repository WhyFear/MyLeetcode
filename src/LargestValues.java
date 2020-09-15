import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        if (root == null) return op;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> levelStack = new ArrayDeque<>();
        nodeStack.push(root);
        levelStack.push(0);
        int levelMax = root.val;
        int preLevel = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pollLast();
            int level = levelStack.pollLast();
            if (level > preLevel) {
                op.add(levelMax);
                levelMax = node.val;
                preLevel = level;
            } else {
                levelMax = Math.max(levelMax, node.val);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                levelStack.push(level + 1);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                levelStack.push(level + 1);
            }
        }
        op.add(levelMax);
        return op;
    }
}
