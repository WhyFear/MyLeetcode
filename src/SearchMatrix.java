/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 从左下边到右上边
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int column = matrix[0].length;
        if (column == 0) return false;

        int i = row - 1;
        while (i >= 0 && matrix[i][0] > target) i--;
        if (i < 0) return false;
        for (int j = 0; j < column; j++) {
            if (target == matrix[i][j]) return true;
        }
        return false;
    }
}
