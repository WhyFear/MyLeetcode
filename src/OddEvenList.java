/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 奇节点和偶节点分别提取出来然后拼接在一起
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode even = head.next;
        ListNode oddTail = head, evenTail = head.next;
        int count = 1; // 判断是奇节点还是偶节点
        ListNode p = head.next.next;
        // 后面打断
        oddTail.next = null;
        evenTail.next = null;
        while (p != null) {
            if (count % 2 == 1) { // 偶数
                oddTail.next = p;
                oddTail = oddTail.next;
                p = p.next;
                oddTail.next = null;
            } else {
                evenTail.next = p;
                evenTail = evenTail.next;
                p = p.next;
                evenTail.next = null;
            }
            count = 1 - count;
        }
        oddTail.next = even;
        return head;
    }
}
