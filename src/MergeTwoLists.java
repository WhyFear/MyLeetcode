/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1048/
 * chaoxi
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode op = new ListNode(-1), endNode = op;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                endNode.next = l2;
                endNode = l2;
                l2 = l2.next;
            } else {
                endNode.next = l1;
                endNode = l1;
                l1 = l1.next;
            }
        }
        if (l1 == null) endNode.next = l2;
        else endNode.next = l1;
        return op.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}