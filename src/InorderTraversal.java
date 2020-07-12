import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        if (root == null) return op;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            while (p.left != null && !visited.contains(p)) {
                stack.push(p);
                visited.add(p);
                p = p.left;
            }
            op.add(p.val);
            if (p.right != null) stack.push(p.right);
        }
        return op;
    }
}
