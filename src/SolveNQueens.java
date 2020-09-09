import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * 没写完,不想写了
 */
public class SolveNQueens {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        char[][] op = new char[n][n];
        res = new ArrayList<>();
        dfs(n, op, new HashSet<>(), new HashSet<>(), 0, 0);
        return res;
    }

    private void dfs(int n, char[][] op, Set<Integer> xPlaced, Set<Integer> yPlaced, int i, int j) {
        if (i >= op.length || j >= op.length) return;
        if (i == op.length - 1 && j == op.length - 1) {
            if (n == 0) {
                List<String> temp = new ArrayList<>();
                for (char[] tmp : op) {
                    temp.add(String.valueOf(tmp));
                }
                res.add(temp);
            }
        }
    }
}
