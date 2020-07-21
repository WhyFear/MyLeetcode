/**
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 * chaoxi
 */
public class WaysToStep {
    public int waysToStep(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[n + 1];

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007 + d[i - 3];
            d[i] %= 1000000007;
        }
        return d[n];
    }
}
