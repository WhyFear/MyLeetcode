import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 5));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int leftN = findChild(root.left);
        if (leftN + 1 == k) return root.val;
        else if (k <= leftN) {
            return kthSmallest(root.left, k);
        } else return kthSmallest(root.right, k - leftN - 1);
    }

    /**
     * 查找子节点个数
     */
    public static int findChild(TreeNode root) {
        if (root == null) return 0;
        return findChild(root.left) + findChild(root.right) + 1;
    }
}
