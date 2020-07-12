/**
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n==1) return true;
        if (n <= 0 || n % 2 == 1) return false;
        while (n > 2) {
            n = n / 2;
            if (n % 2 == 1) return false;
        }
        return true;
    }
}
