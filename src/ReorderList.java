/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head, slowPre = head;
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPre.next = null; // 前半部分打断
        //翻转链表
        ListNode tempHead = new ListNode(-1), q, tempHeadNext;
        while (slow != null) {
            q = slow.next;
            tempHeadNext = tempHead.next;
            tempHead.next = slow;
            slow.next = tempHeadNext;
            slow = q;
        }
        //插入
        ListNode p = head, temp;
        slow = tempHead.next;
        while (slow != null && p.next != null) {
            temp = slow.next;
            slow.next = p.next;
            p.next = slow;
            p = p.next.next;
            slow = temp;
        }
        if (p.next == null) p.next = slow;
    }
}
