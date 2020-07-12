/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {
    public static void main(String[] args) {
        int[] fuck = new int[]{1, 4, 5};
        int[] fuck1 = new int[]{1, 3, 4};
        int[] fuck2 = new int[]{2, 6};
        ListNode head = new ListNode(-1), p = head;
        ListNode head1 = new ListNode(-1), p1 = head1;
        ListNode head2 = new ListNode(-1), p2 = head2;
        for (int num : fuck) {
            p.next = new ListNode(num);
            p = p.next;
        }
        for (int num : fuck1) {
            p1.next = new ListNode(num);
            p1 = p1.next;
        }
        for (int num : fuck2) {
            p2.next = new ListNode(num);
            p2 = p2.next;
        }
        ListNode[] asd = new ListNode[]{head.next, head1.next, head2.next};
        System.out.println(mergeKLists(asd));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int j = 0;
        while (lists[j] == null) {
            j++;
            if (j == lists.length) return null;
        }
        ListNode op = lists[j];
        for (int i = j + 1; i < lists.length; i++) {
            ListNode p = lists[i];
            if (p != null)
                op = mergeTwoLists(op, p);
        }
        return op;
    }
}
