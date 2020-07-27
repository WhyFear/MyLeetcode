/**
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {
    public static int deepSearch(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + deepSearch(grid, i - 1, j) + deepSearch(grid, i + 1, j) + deepSearch(grid, i, j - 1) + deepSearch(grid, i, j + 1);
        } else
            return 0;
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int num = deepSearch(matrix, i, j);
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }

    /**
     * dp版本
     */
    public int maximalSquareDP(char[][] matrix) {
        int row = matrix.length;
        if (row < 1) return 0;
        int column = matrix[0].length;
        if (column < 1) return 0;
        int max = 0;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }
        for (int j = 0; j < column; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(dp[0][j], max);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
