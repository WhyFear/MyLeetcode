/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {
    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode fast = head.next.next, slow = head;
        while (fast != slow && fast != null && slow != null) {
            slow = slow.next;
            try {
                fast = fast.next.next;
            } catch (java.lang.NullPointerException e) {
                return false;
            }
        }
        return fast != null && slow != null;
    }
}
