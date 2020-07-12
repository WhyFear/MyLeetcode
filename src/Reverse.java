/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Reverse {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) return 0;
        boolean negativeNumber = false;
        if (x < 0) {
            x = -x;
            negativeNumber = true;
        }
        String temp = new StringBuilder(String.valueOf(x)).reverse().toString();
        int op = 0;
        try {
            op = Integer.parseInt(temp);
        } catch (java.lang.NumberFormatException e) {
            return 0;
        }
        if (negativeNumber) return -op;
        else return op;
    }
}
