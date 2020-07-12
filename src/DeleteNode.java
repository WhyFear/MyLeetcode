public class DeleteNode {
    /**
     * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
     * 删除当前节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode p = head;
        while (p.next != null && p.next.val != val) p = p.next;
        if (p.next != null) p.next = p.next.next;
        return head;
    }
}
