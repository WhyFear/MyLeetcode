/**
 * https://leetcode-cn.com/problems/integer-break/
 * chaoxi
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = 1;
        while (n > 4) {
            n = n - 3;
            a = a * 3;
        }
        return a * n;
    }
}
