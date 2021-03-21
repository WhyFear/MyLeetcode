import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return;
        int column = matrix[0].length;
        if (column == 0) return;
        Set<Integer> setZeroX = new HashSet<>();
        Set<Integer> setZeroY = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    setZeroX.add(i);
                    setZeroY.add(j);
                }
            }
        }
        for (int i : setZeroX) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : setZeroY) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
