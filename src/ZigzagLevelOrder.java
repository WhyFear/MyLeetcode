import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        System.out.println(zigzagLevelOrder(node3));
    }

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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        op = store(root, op, 0);
        int i = 0;
        for (List<Integer> temp : op) {
            if (i == 1) {
                Collections.reverse(temp);
            }
            i = 1 - i;
        }
        return op;
    }
}
