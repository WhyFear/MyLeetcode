import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * chaoxi
 * 具体参考：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
 */
public class MaxQueue {
    Deque<Integer> queue;
    Deque<Integer> maxStack;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public int max_value() {
        return maxStack.isEmpty() ? -1 : maxStack.peekLast();
    }

    public void push_back(int value) {
        queue.push(value);
        while (!maxStack.isEmpty() && value > maxStack.peek()) {
            maxStack.pop();
        }
        maxStack.push(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        else {
            int result = queue.pollLast();
            if (result == maxStack.peekLast()) maxStack.pollLast();
            return result;
        }
    }
}