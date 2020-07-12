/**
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 * 判断奇偶通过最后一位数是否为零，为零则为偶数，否则为奇数
 * 二进制除以2可以右移一位。
 */
public class NumSteps {
    public int numSteps(String s) {
        int op = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1) {
            op++;
            if (isOdd(sb)) addOne(sb);
            else dividedByTwo(sb);
        }
        return op;
    }

    /**
     * 判断是否为奇数
     */
    private boolean isOdd(StringBuilder s) {
        return s.charAt(s.length() - 1) == '1';
    }

    /**
     * 加一操作
     */
    private void addOne(StringBuilder s) {
        boolean add = true; //进位标志
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (add) {
                    s.replace(i, i + 1, "0");
                }
            } else {
                if (add) {
                    s.replace(i, i + 1, "1");
                    add = false;
                }
            }
        }
        if (add) s.insert(0, "1");
    }

    /**
     * 除以二操作，直接右移一位
     */
    private void dividedByTwo(StringBuilder s) {
        s.deleteCharAt(s.length() - 1);
    }
}
