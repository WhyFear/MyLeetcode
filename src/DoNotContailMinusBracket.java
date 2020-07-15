import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 字节跳动2020-7-15笔试题
 * 不含负号的括号数量
 * 如((1+2+3) - (4+5)-6)为2
 * 1 + 2 为 0
 * 70 %
 */
public class DoNotContailMinusBracket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        int op = 0;
        for (char chr : str.toCharArray()) {
            if (chr == '(') {
                stack.push(chr);
            } else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() == '-') stack.pop();
                stack.pop();
                op++;
            } else if (chr == '-') {
                if (!stack.isEmpty()) {
                    if (stack.peek() != '-') {
                        stack.push('-');
                        op--;
                    }
                }
            }
        }
        System.out.println(op);
    }
}
