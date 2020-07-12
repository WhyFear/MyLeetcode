/**
 * https://leetcode-cn.com/problems/magic-squares-in-grid/
 */
public class NumMagicSquaresInside {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        int op = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (isMagicSquare(grid, i, j)) op++;
            }
        }
        return op;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j) {
        //各数不相等
        int[] fuck = new int[9];
        int count = 0;
        for (int m = 0; m < 3; m++)
            for (int n = 0; n < 3; n++) {
                if (grid[i + m][j + n] > 9 || grid[i + m][j + n] < 1) return false;
                if (fuck[grid[i + m][j + n] - 1] == 0) {
                    fuck[grid[i + m][j + n] - 1] = 1;
                    count++;
                }
            }
        if (count != 9) return false;
        //行比较
        int temp = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != temp) return false;
        if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != temp) return false;
        //列比较
        if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != temp) return false;
        if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != temp) return false;
        if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != temp) return false;
        //对角线比较
        if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != temp) return false;
        return grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] == temp;
    }
}
