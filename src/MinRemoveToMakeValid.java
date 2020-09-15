import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
 * 思路chaoxi
 * 第一次遍历用栈留下无效括号索引
 * 第二次遍历取可用字符拼接成串
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> leftBracketStack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '(') {
                leftBracketStack.push(i);
            } else if (chr == ')') {
                if (!leftBracketStack.isEmpty()) {
                    set.add(leftBracketStack.pop());
                    set.add(i);
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '(' || chr == ')') {
                if (set.contains(i)) sb.append(chr);
            } else sb.append(chr);
        }
        return sb.toString();
    }
}
