/**
 * https://leetcode-cn.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * 应该使用迪杰斯特拉算法实现，我没写出来，太菜了。
 */
public class MinCost {
    public int minCost(int[][] grid) {
        int row = grid.length;
        if (row < 1) return 0;
        int column = grid[0].length;
        if (column < 1) return 0;
        int[][] dp = new int[row][column];
        for (int i = 1; i < row; i++) {
            if (grid[i - 1][0] == 3) dp[i][0] = dp[i - 1][0];
            else dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j < column; j++) {
            if (grid[0][j - 1] == 1) dp[0][j] = dp[0][j - 1];
            else dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                int upToDown = dp[i - 1][0];
                int leftToRight = dp[i][j - 1];
                if (grid[i - 1][j] != 3) upToDown++;
                if (grid[i][j - 1] != 1) leftToRight++;
                dp[i][j] = Math.min(upToDown, leftToRight);
            }
        }
        return dp[row - 1][column - 1];
    }
}
