import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> op = new ArrayList<>();
        if (root == null) return op;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> level = new ArrayDeque<>();
        stack.push(root);
        level.push(0);
        int currentLevel = 0, currentLevelNodeCount = 0;
        long currentLevelSum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            int nodeLevel = level.pollLast();
            if (currentLevel == nodeLevel) {
                currentLevelNodeCount++;
                currentLevelSum += node.val;
            } else {
                op.add((double) currentLevelSum / currentLevelNodeCount);
                currentLevelNodeCount = 1;
                currentLevel = nodeLevel;
                currentLevelSum = node.val;
            }
            if (node.left != null) {
                stack.push(node.left);
                level.push(nodeLevel + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                level.push(nodeLevel + 1);
            }
        }
        op.add((double) currentLevelSum / currentLevelNodeCount);
        return op;
    }
}
