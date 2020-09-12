/**
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int row = grid.length, column = grid[0].length;
        int[] upToDown = new int[row];
        int[] leftToRight = new int[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int num = grid[i][j];
                upToDown[j] = Math.max(upToDown[j], num);
                leftToRight[i] = Math.max(leftToRight[i], num);
            }
        }
        int op = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                op += Math.min(upToDown[j], leftToRight[i]) - grid[i][j];
            }
        }
        return op;
    }
}
