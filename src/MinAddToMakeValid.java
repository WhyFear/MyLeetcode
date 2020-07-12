import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
 * 左括号进栈，右括号op++
 * 不用栈就行了。
 */
public class MinAddToMakeValid {
    public int minAddToMakeValid(String S) {
        int op = 0;
        int leftBracketCount = 0;
        for (char chr : S.toCharArray()) {
            if (chr == '(') {
                leftBracketCount++;
            } else {
                if (leftBracketCount > 0) {
                    leftBracketCount--;
                } else {
                    op++;
                }
            }
        }
        return op + leftBracketCount;
    }
}
