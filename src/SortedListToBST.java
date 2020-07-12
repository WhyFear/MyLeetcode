import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 请看官方题解，非常巧妙
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-by-/
 * chaoxi
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    public TreeNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(dummyHead.next);
        root.right = helper(slow.next);
        return root;
    }
}
