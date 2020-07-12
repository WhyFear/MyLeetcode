
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1023/
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode op = null, p = head;
        Set<ListNode> visited = new HashSet<>();
        while (p != null) {
            if (visited.contains(p)) {
                op = p;
                break;
            }
            visited.add(p);
            p = p.next;
        }
        return op;
    }
}
