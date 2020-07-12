/**
 * https://leetcode-cn.com/problems/making-a-large-island/
 * 没写完，还是不会
 */
public class LargestIsland {
    int op = 0;
    int temp = 0;
    boolean extended = false; //是否向外扩展过一格
    int[][] visited; //0代表未探索，1代表探索过这个岛屿，2代表曾经作为可能扩展的岛屿被探索过。


    public int largestIsland(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] != 1) {
                    temp = 0;
                    extended = false;
                    dfs(grid, i, j);
                    op = Math.max(op, temp);
                }
            }
        }
        return op;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) { //判断四面能不能接触到其他岛屿（不能是本岛）
            if (grid[i + 1][j] == 1 && !extended) {

                dfs(grid, i + 1, j);
                temp++;
            }

        }
    }
}
