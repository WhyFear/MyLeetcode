import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 */
public class SumSubarrayMins {
    int MOD = 1000000007;

    /**
     * 此方法超时
     */
    public int mySumSubarrayMins(int[] A) {
        long op = A[0];
        if (A.length <= 1) return (int) (op % 1000000007);
        int[] dp = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            op += A[i];
            int j = i - 1;
            int tempMin = A[i];
            while (j >= 0) {
                if (j == i - 1) {
                    dp[j] = Math.min(tempMin, A[j]);
                } else if (tempMin < dp[j]) dp[j] = tempMin;
                op += dp[j];
                j--;
            }
        }
        return (int) (op % 1000000007);
    }

    /**
     * 别人的
     * https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/leetcodebi-ji-java-py-si-ke-yi-dao-ti-907-zi-shu-3/
     */
    public int sumSubarrayMins(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int res = 0, tmp = 0;
        for (int value : A) {
            int count = 1;
            while (!stack.empty() && stack.peek().val >= value) {
                Pair pop = stack.pop();
                count += pop.count;
                tmp -= pop.val * pop.count;
            }
            stack.push(new Pair(value, count));
            tmp += value * count;
            res += tmp;
            res %= MOD;
        }
        return res;
    }
}

class Pair {
    public int val;
    public int count;

    public Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
