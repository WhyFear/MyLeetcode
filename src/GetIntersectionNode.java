import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1024/
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        Set<ListNode> visitedA = new HashSet<>(), visitedB = new HashSet<>();
        while (p != null && q != null) {
            visitedA.add(p);
            visitedB.add(q);
            if (visitedB.contains(p)) return p;
            if (visitedA.contains(q)) return q;
            p = p.next;
            q = q.next;
        }
        while (p != null) {
            if (visitedB.contains(p)) return p;
            p = p.next;
        }
        while (q != null) {
            if (visitedA.contains(q)) return q;
            q = q.next;
        }
        return null;
    }
}
