/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * dfs方法超时
 */
public class UniquePathsWithObstacles {
    int op;
    int maxI, maxJ;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        op = 0;
        maxI = obstacleGrid.length - 1;
        maxJ = obstacleGrid[0].length - 1;
        dfs(obstacleGrid, 0, 0);
        return op;
    }

    private void dfs(int[][] obstacleGrid, int i, int j) {
        if (obstacleGrid[i][j] == 1) return;
        if (i == maxI && j == maxJ) {
            op++;
            return;
        }
        if (i < maxI)
            dfs(obstacleGrid, i + 1, j);
        if (j < maxJ)
            dfs(obstacleGrid, i, j + 1);
    }
}
/*
闫氏DP法，没有空间压缩，方便理解。

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
          int m = ob.length;
        int n = ob[0].length;
        if(m == 0 || n == 0) return 0;
        // `ob[i][j] == 1`表示无障碍物，`dp[i][j] = dp[i - 1][j] + d[i][j - 1]`
        int[][] dp = new int[m][n];
        // 初始化
        // 第0行和第0列分别遍历，赋值为1；
        // 如果碰到障碍物，从这个点之后全为0，因为碰到障碍物，之后都不可达了。
        for(int i = 0; i < m; i++) {
            if(ob[i][0] == 1) break;
            else dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(ob[0][i] == 1) break;
            else dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // `ob[i][j] == 1`表示有障碍物，直接令`dp[i][j] = 0`;
                if(ob[i][j] == 1) dp[i][j] = 0;
                // `ob[i][j] == 0`表示无障碍物，`dp[i][j] = dp[i - 1][j] + d[i][j - 1]`
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
 */
