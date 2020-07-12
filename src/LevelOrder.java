import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    public static List<List<Integer>> store(TreeNode root, List<List<Integer>> op, int level) {
        if (root == null) return op;
        if (op.size() <= level) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            op.add(tmp);
        } else op.get(level).add(root.val);
        if (root.left != null) store(root.left, op, level + 1);
        if (root.right != null) store(root.right, op, level + 1);
        return op;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        op = store(root, op, 0);
        int i = 0;
        return op;
    }
}
