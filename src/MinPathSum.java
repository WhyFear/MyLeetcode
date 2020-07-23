import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */

public class MinPathSum {
    private int op = Integer.MAX_VALUE;

    private void digui(int[][] grid, int pathSum, int i, int j) {
        if (op < pathSum + grid[i][j]) return;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            op = Math.min(pathSum + grid[i][j], op);
            return;
        }
        if (i < grid.length - 1) digui(grid, pathSum + grid[i][j], i + 1, j);
        if (j < grid[0].length - 1) digui(grid, pathSum + grid[i][j], i, j + 1);
    }

    /**
     * 递归版本，超时
     */
    public int minPathSumVer1(int[][] grid) {
        digui(grid, 0, 0, 0);
        return op;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-path-sum/
     * 动态规划
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        Deque<int[]> bfsQueue = new ArrayDeque<>();
        bfsQueue.push(new int[]{row - 1, column - 1});
        int[][] visited = new int[row][column];
        while (!bfsQueue.isEmpty()) {
            int[] temp = bfsQueue.pollLast();
            int i = temp[0], j = temp[1];
            if (visited[i][j] != 1) {
                visited[i][j] = 1;
                if (i == row - 1 && j < column - 1)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (i < row - 1 && j == column - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (i < row - 1 && j < column - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);

                if (i > 0) bfsQueue.push(new int[]{i - 1, j});
                if (j > 0) bfsQueue.push(new int[]{i, j - 1});
            }
        }
        return grid[0][0];
    }

    /**
     * 另一个版本的dp，更快
     * 先首行和首列，然后再循环
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
