/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countZeroAndOne(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] op = new int[2];
        for (char tmp : str.toCharArray()) {
            if (tmp == '0') op[0]++;
            else op[1]++;
        }
        return op;
    }
}
