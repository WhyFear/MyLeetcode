/**
 * 偶数就除以二，奇数就找最大约数
 * chaoxi
 */
public class MinSteps {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}
