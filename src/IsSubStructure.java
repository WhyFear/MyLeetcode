public class IsSubStructure {
    /**
     * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
     * 感谢剑指offer
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean op = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                op = doseTreeAhasTreeB(A, B);
            }
            if (!op) op = isSubStructure(A.left, B);
            if (!op) op = isSubStructure(A.right, B);
        }
        return op;
    }

    private boolean doseTreeAhasTreeB(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return doseTreeAhasTreeB(A.left, B.left) && doseTreeAhasTreeB(A.right, B.right);
    }
}
