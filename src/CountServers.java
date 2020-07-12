/**
 * https://leetcode-cn.com/problems/count-servers-that-communicate/
 */
public class CountServers {
    public int countServers(int[][] grid) {
        int op = 0;
        int[] column = new int[grid.length];
        int[] row = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    column[i]++;
                    row[j]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (column[i] > 1 || row[j] > 1)) {
                    op++;
                }
            }
        }
        return op;
    }
}
