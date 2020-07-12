import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string/submissions/
 * StringBuffer StringBuilder 区别：
 * StringBuilder 线程不安全，但是单线程中性能比StringBuffer好
 * StringBuffer 线程安全。
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]e"));
    }

    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer();
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuffer> ansStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) multi = multi * 10 + c - '0';
            else if (c == '[') {
                ansStack.add(ans);
                multiStack.add(multi);
                ans = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else {
                StringBuffer ansTmp = ansStack.pop();
                int tmp = multiStack.pop();
                ansTmp.append(String.valueOf(ans).repeat(Math.max(0, tmp)));
                ans = ansTmp;
            }
        }
        return ans.toString();
    }
}
