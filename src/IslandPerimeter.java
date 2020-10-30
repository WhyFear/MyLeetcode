/**
 * https://leetcode-cn.com/problems/island-perimeter/
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int op = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    op += count(grid, i - 1, j) +
                            count(grid, i, j - 1) +
                            count(grid, i, j + 1) +
                            count(grid, i + 1, j);
                }
            }
        }
        return op;
    }

    private int count(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 1;
        return grid[i][j] == 1 ? 0 : 1;
    }
}
