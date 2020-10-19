import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return help(S).equals(help(T));
    }

    private String help(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c != '#') stack.push(c);
            else if (!stack.isEmpty()) stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
