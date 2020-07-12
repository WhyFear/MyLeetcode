import java.util.*;

/**
 * https://leetcode-cn.com/problems/list-of-depth-lcci/submissions/
 */
public class ListOfDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        System.out.println(Arrays.toString(listOfDepth(root)));
    }
    public static ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> op = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, Integer> level = new HashMap<>();
        queue.add(tree);
        level.put(tree, 0);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pollLast();
            int nodeLevel = level.get(temp);
            if (nodeLevel >= op.size())
                op.add(new ListNode(temp.val));
            else {
                ListNode tempListNode = op.get(nodeLevel);
                ListNode p = tempListNode;
                while (p.next != null) p = p.next;
                p.next = new ListNode(temp.val);
                op.set(nodeLevel, tempListNode);
            }
            if (temp.left != null) {
                queue.push(temp.left);
                level.put(temp.left, nodeLevel + 1);
            }
            if (temp.right != null) {
                queue.push(temp.right);
                level.put(temp.right, nodeLevel + 1);
            }
        }
        ListNode[] rt = new ListNode[op.size()];
        for (int i = 0; i < op.size(); i++) rt[i] = op.get(i);
        return rt;
    }
}
