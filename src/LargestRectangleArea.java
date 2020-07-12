import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 单调栈的应用，类似题：接雨水
 * chaoxi
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>(); //栈中只需要存储当前的下标即可
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) { //遇到栈顶比当前数大的就开始弹出
                int height = heights[stack.removeLast()];

                while (!stack.isEmpty() && heights[stack.peekLast()] == height) { //对于相同高度的处理，直接舍弃，不会影响最后的结果
                    stack.removeLast();
                }

                int width;
                if (stack.isEmpty()) { //如果是空，说明最左边可以延伸到数组开头。空说明左边的都比自己高
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }

                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }

        //遍历完后对栈中剩余数据进行处理
        // 可以看出与上面for循环内的代码非常像，说明可以优化。优化代码再下方
        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];

            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }

            area = Math.max(area, width * height);
        }
        return area;
    }
}
/*
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int area = 0;
        int[] newHeights = new int[len + 2];  //两端加上两个零，这样就不用对栈是否空进行判断，for循环内的代码也可以简化
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int width  = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }
}
 */