/**
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
 * 广度或者深度都可以，遇到1就将周围所有符合条件的1置0，然后继续
 */
public class NumIslands {
    int nr, nc;

    void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        nr = grid.length;
        nc = grid[0].length;
        int op = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    op++;
                    dfs(grid, r, c);
                }
            }
        }
        return op;
    }
}
