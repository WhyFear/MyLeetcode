import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/arithmetic-slices/
 * chaoxi
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int len  = A.length;
        int[] dp = new int[len];
        int sum = 0;
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
