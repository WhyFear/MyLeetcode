import javax.swing.text.TabExpander;

public class DeleteDuplicates {
    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.next.val == p.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     */
    public ListNode deleteDuplicatesii(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = new ListNode(head.val - 1); //应对头几个节点就是相同的情况。
        temp.next = head;
        ListNode p = temp;
        ListNode pre = temp;
        boolean flag = false;
        while (p != null) {
            while (p.next != null && p.next.val == p.val) { //相同的就全部跳过
                p.next = p.next.next;
                flag = true;
            }
            if (flag) {
                pre.next = p.next; //从相同的节点前一个开始，直接连接到后续不相同的第一个节点
                flag = false;
                p = pre; //p重置到它前面
            }
            pre = p;
            p = p.next;
        }
        return temp.next;
    }
}
