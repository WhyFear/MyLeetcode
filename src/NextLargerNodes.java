import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 * 单调栈
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        List<Integer> nodes = new ArrayList<>();
        while (p != null) {
            nodes.add(p.val);
            p = p.next;
        }
        int len = nodes.size();
        int[] op = new int[len];
        Stack<int[]> smallTopStack = new Stack<>(); //单调递增栈 比栈顶小的就push，否则弹出。
        int maxIndex = len - 1;
        smallTopStack.push(new int[]{nodes.get(maxIndex), maxIndex});
        for (int i = len - 2; i >= 0; i--) {
            int nodeVal = nodes.get(i);
            while (!smallTopStack.isEmpty() && nodeVal >= smallTopStack.peek()[0]) //把比自己小的值全部清空
                smallTopStack.pop();

            if (nodeVal >= nodes.get(maxIndex)) {
                op[i] = 0; //可加可不加，本身就是0
                maxIndex = i;
            } else {
                op[i] = smallTopStack.peek()[0];
            }

            smallTopStack.push(new int[]{nodeVal, i});
        }
        return op;
    }
}
