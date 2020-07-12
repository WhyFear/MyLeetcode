/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1038/
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        System.out.println(reverseList(l2));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode op = new ListNode(-1), p = head, temp, opNext;
        while (p != null) {
            temp = p.next;
            opNext = op.next;
            op.next = p;
            p.next = opNext;
            p = temp;
        }
        return op.next;
    }
}

