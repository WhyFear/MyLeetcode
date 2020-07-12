import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
 */
public class LowestCommonAncestor {
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
        System.out.println(lowestCommonAncestor(node3, node0, node8).val);
    }

    public static Stack<TreeNode> findNode(TreeNode root, TreeNode targetNode, Stack<TreeNode> stackPath) {
        if (root == null) return stackPath;
        stackPath.push(root);
        if (root == targetNode) return stackPath;
        if (root.left != null) {
            stackPath = findNode(root.left, targetNode, stackPath);
            if (stackPath.peek() == targetNode) return stackPath;
        }
        if (root.right != null) {
            stackPath = findNode(root.right, targetNode, stackPath);
            if (stackPath.peek() == targetNode) return stackPath;
        }
        stackPath.pop();
        return stackPath;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack = findNode(root, p, pStack);
        qStack = findNode(root, q, qStack);
        Set<TreeNode> tmp = new HashSet<>();
        while (!pStack.empty()) tmp.add(pStack.pop());
        while (!qStack.empty()) {
            TreeNode result = qStack.pop();
            if (tmp.contains(result))
                return result;
        }
        return root;
    }
}
