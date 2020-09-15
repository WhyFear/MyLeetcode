import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfArithmeticSlices {

    /**
     * https://leetcode-cn.com/problems/arithmetic-slices/
     * chaoxi
     */
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
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

    /**
     * https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/
     * 做不来
     */
    public int numberOfArithmeticSlicesII(int[] A) {
        int op = 0, tempCount = 0;
        Map<Integer, Integer> map;
        int max = 0;
        for (int val : A) {
            max = Math.max(max, val);
        }
        for (int difference = 1; difference <= max; difference++) {
            map = new HashMap<>();
            for (int val : A) {
                int result = map.getOrDefault(val - difference, 0) + 1;
                map.put(val, result);
                tempCount = Math.max(tempCount, result);
                if (tempCount > 3) op++;
            }
        }
        return op;
    }
}
