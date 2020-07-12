import java.text.DecimalFormat;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * 考验快速乘方，如64为2*32 32为2*16，使用递归可以快速求平方
 * 剑指offer p112
 * 代码可参考：https://leetcode-cn.com/problems/powx-n/comments/10689
 */

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(-1.00000, 2147483647));
    }

    public static double myPow(double x, int n) {
        if (x == 0 & n == 0) return 1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        double op = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                op = op * x;
            }
        } else {
            n = -n;
            if (n < 0) return 0;
            for (int i = 0; i < n; i++) {
                op = op * x;
            }
            op = 1 / op;
        }
        return op;
    }
}
