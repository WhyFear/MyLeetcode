import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
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
        System.out.println(binaryTreePaths(node3));
    }

    public static void digui(TreeNode root, List<String> op, String str) {
        if (str.equals("")) str = String.valueOf(root.val);
        else str = str + "->" + root.val;
        if (root.left == null && root.right == null) {
            op.add(str);
            return;
        }
        if (root.left != null) digui(root.left, op, str);
        if (root.right != null) digui(root.right, op, str);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> op = new ArrayList<>();
        if (root == null) return op;
        digui(root, op, "");
        return op;
    }
}
