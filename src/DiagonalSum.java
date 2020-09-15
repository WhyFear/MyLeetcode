/**
 * https://leetcode-cn.com/problems/matrix-diagonal-sum/
 */
public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int op = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            op += mat[i][i];
            op += mat[len - i - 1][i];
        }
        if (len % 2 == 1) return op - mat[len / 2][len / 2];
        else return op;
    }
}
