/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * 二分法超时
 * chaoxi
 * 使用的牛顿迭代法
 * 开放操作具体请参考这篇文章: https://kb.cnblogs.com/page/189867/
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
