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
     * 动态规划
     */
    public int minPathSum(int[][] grid) {
        Deque<int[]> bfsQueue = new ArrayDeque<>();
        bfsQueue.push(new int[]{grid.length - 1, grid[0].length - 1});
        int[][] visited = new int[grid.length][grid[0].length];
        while (!bfsQueue.isEmpty()) {
            int[] temp = bfsQueue.pollLast();
            int i = temp[0], j = temp[1];
            if (visited[i][j] != 1) {
                visited[i][j] = 1;
                if (i == grid.length - 1 && j < grid[0].length - 1)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (i < grid.length - 1 && j == grid[0].length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (i < grid.length - 1 && j < grid[0].length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);

                if (i > 0) bfsQueue.push(new int[]{i - 1, j});
                if (j > 0) bfsQueue.push(new int[]{i, j - 1});
            }
        }
        return grid[0][0];
    }
}
