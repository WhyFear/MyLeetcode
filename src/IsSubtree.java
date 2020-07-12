/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class IsSubtree {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        //t是s的子树，要么t等于s，要么t等于s的左/右子树。
        return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean subFrom(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}