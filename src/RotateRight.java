/**
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next == null) return head;
        ListNode end = head;
        int len = 1;
        while (end.next != null) {
            len++;
            end = end.next;
        }
        if (k == len) return head;
        k = k < len ? k : k % len;
        end.next = head;

        int i = 1;
        ListNode op = head;
        while (i < len - k) {
            op = op.next;
            i++;
        }
        head = op.next;
        op.next = null;
        return head;
    }
}
