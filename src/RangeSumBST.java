public class RangeSumBST {
    /**
     * https://leetcode-cn.com/problems/range-sum-of-bst/
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        if (root.val < low || root.val > high) return left + right;
        else return left + right + root.val;
    }
}
