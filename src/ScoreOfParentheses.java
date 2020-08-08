import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 * chaoxi
 */

public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // The score of the current frame

        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
