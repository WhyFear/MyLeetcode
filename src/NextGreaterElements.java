import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 暴力居然tong过了
 * 应该使用单调栈
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] op = new int[len];

        for (int i = 0; i < len; i++) {
            op[i] = -1;
            int j = (i + 1) % len;
            while (j != i) {
                if (nums[j] > nums[i]) {
                    op[i] = nums[j];
                    break;
                }
                j = (j + 1) % len;
            }
        }
        return op;
    }

    /**
     * chaoxi
     * 单调栈方法
     */
    public int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * len - 1; i >= 0; --i) { //相当于两轮遍历，第一次将前面的大数入栈
            while (!stack.empty() && nums[stack.peek()] <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % len);
        }
        return res;
    }
}
