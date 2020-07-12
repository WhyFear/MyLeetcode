import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-happy-string/
 * chaoxi
 */
public class LongestDiverseString {
    public String longestDiverseString(int a, int b, int c) {
        MyChar[] myChars = new MyChar[]{
                new MyChar('a', a),
                new MyChar('b', b),
                new MyChar('c', c),
        };
        StringBuilder op = new StringBuilder();

        while (true) {
            Arrays.sort(myChars);
            //先放最多的, 如果上个放的2个字符串和剩余个数最多的字符相同，则放置次多的字符

            if (op.length() >= 2 &&
                    op.charAt(op.length() - 1) == myChars[2].ch &&
                    op.charAt(op.length() - 2) == myChars[2].ch) {
                if (myChars[1].count-- > 0) {
                    op.append(myChars[1].ch);
                } else {
                    break;
                }

            } else {
                if (myChars[2].count-- > 0) {
                    op.append(myChars[2].ch);
                } else {
                    break;
                }
            }
        }
        return op.toString();
    }

    private static class MyChar implements Comparable {
        char ch;
        int count;

        public MyChar(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            MyChar other = (MyChar) o;
            return this.count - other.count;
        }
    }
}

