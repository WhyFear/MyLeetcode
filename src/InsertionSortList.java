/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = new ListNode(-1); // 虚拟头结点
        temp.next = head;
        ListNode p = head.next, q, pNext;
        head.next = null; //默认提取出一个节点作为开头,并把它后面打断
        while (p != null) {
            q = temp;
            while (q.next != null && q.next.val < p.val) q = q.next;
            pNext = p.next;
            p.next = q.next;
            q.next = p;
            p = pNext;
        }
        return temp.next;
    }
}
