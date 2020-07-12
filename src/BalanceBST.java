public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode head) {
        if (head == null) {
            return null;
        }
        // 找到链表的中点
        TreeNode dummyHead = new TreeNode(0);
        dummyHead.right = head;
        TreeNode pre = dummyHead;
        TreeNode slow = head;
        TreeNode fast = head;
        while (fast != null && fast.right != null) {
            pre = slow;
            slow = slow.right;
            fast = fast.right.right;
        }
        pre.right = null; //打断链表

        TreeNode root = new TreeNode(slow.val);
        root.left = helper(dummyHead.right);
        root.right = helper(slow.right);
        return root;
    }
}
