/**
 * 解题思路：
 * 步骤一：类似于求路径总和，如果用 bracktrack，时间复杂度 O(f ^ d)不靠谱啊。果断套 DP。
 * 步骤二：求状态转移方程 (STE)：
 * 状态：dp[i][j] 代表 扔 i 个骰子和为 j；
 * 方程：dp[i][j] 与 dp[i - 1] 的关系是什么呢？ 第 i 次我投了 k ( 1 <= k <= f)，那么前 i - 1 次 和 为 j - k，对应 dp[i - 1][j - k]；
 * 于是有最终方程：dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2] + ... + dp[i - 1][j - f]
 * 边界条件： dp[1][k] = 1 ( 1<= k <= min(target, f) )
 * chaoxi
 */
public class NumRollsToTarget {
    private static final int MOD = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[31][1001];
        int min = Math.min(f, target);
        for (int i = 1; i <= min; i++) {
            dp[1][i] = 1;
        }
        int targetMax = d * f;
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= targetMax; j++) {
                for (int k = 1; j - k >= 0 && k <= f; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[d][target];
    }
}
