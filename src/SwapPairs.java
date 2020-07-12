/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 题目要求不能直接交换值
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, frontP = head;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = p;
            if (p == head) head = q;
            else frontP.next = q;
            frontP = p;
            p = p.next;
        }
        return head;
    }
}
