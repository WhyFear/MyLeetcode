/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {
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
}
