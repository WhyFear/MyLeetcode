import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] op = new int[n][n];
        int index = 1, i = 0, j = 0;
        while (index <= n * n) {
            while (j < n && op[i][j] == 0) op[i][j++] = index++;
            i++;
            j--;
            while (i < n && op[i][j] == 0) op[i++][j] = index++;
            i--;
            j--;
            while (j >= 0 && op[i][j] == 0) op[i][j--] = index++;
            i--;
            j++;
            while (i >= 0 && op[i][j] == 0) op[i--][j] = index++;
            i++;
            j++;
        }
        return op;
    }
}
