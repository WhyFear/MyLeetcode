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
}
