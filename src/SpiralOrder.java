import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> op = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) return op;
        int m = matrix[0].length;
        int len = m * n;
        int[][] visited = new int[n][m];
        int index = 0, i = 0, j = 0, direction = 1;
        while (index < len) {
            switch (direction) {
                case 1:
                    while (j < m && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        index++;
                        op.add(matrix[i][j++]);
                    }
                    i++;
                    j--;
                    direction = 2;
                case 2:
                    while (i < n && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        index++;
                        op.add(matrix[i++][j]);
                    }
                    i--;
                    j--;
                    direction = 3;
                case 3:
                    while (j >= 0 && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        index++;
                        op.add(matrix[i][j--]);
                    }
                    i--;
                    j++;
                    direction = 4;
                case 4:
                    while (i >= 0 && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        index++;
                        op.add(matrix[i--][j]);
                    }
                    i++;
                    j++;
                    direction = 1;
            }
        }
        return op;
    }
}

