import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 * chaoxi
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）
 * 它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        return root == null || (root.val > min && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max));
    }
}
