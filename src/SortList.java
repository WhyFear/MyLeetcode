/**
 * https://leetcode-cn.com/problems/sort-list/
 * 好好理解快慢指针
 */
public class SortList {
    public static void main(String[] args) {
        int[] fuck = new int[]{4, 19, 14, 5, -3, 1, 8, 5, 11, 15};
        ListNode head = new ListNode(-1), p = head;
        for (int num : fuck) {
            p.next = new ListNode(num);
            p = p.next;
        }
        System.out.println(sortList(head.next));
    }

    public static ListNode sortList(ListNode head) {
        ListNode op = new ListNode(-1), q = head, temp, qProir = q;
        op.next = head;
        while (q != null) {
            temp = op;
            while (temp.next.val < q.val) temp = temp.next;
            if (temp.next != q) {
                qProir.next = q.next;
                q.next = temp.next;
                temp.next = q;
                q = qProir;
            }
            qProir = q;
            q = q.next;
        }
        return op.next;
    }
}
