/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }

    /**
     * 自己的，超时。
     */
    public static int myClimbStairs(int n) {
        if (n <= 3) return n;
        int op = 2;
        for (int i = 0; i < n - 2; i++) {
            op += myClimbStairs(i + 1);
        }
        return op;
    }

    /**
     * 别人的
     * 类似于斐波那契数列，先计算小的，再计算大的
     */
    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
}
