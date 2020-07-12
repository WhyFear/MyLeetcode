import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 * chaoxi
 */
public class CheckValidString {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>(), star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left.push(i);
            else if (s.charAt(i) == '*') star.push(i);
            else {
                if (left.empty() && star.empty()) return false;
                if (!left.empty()) left.pop();
                else star.pop();
            }
        }
        while (!left.empty() && !star.empty()) {
            if (left.peek() > star.peek()) return false;
            left.pop();
            star.pop();
        }
        return left.empty();
    }
}
