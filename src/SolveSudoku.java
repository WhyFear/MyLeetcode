import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 * 做不来,我不配
 */
public class SolveSudoku {
    Set<Character>[] rows;
    Set<Character>[] columns;
    Set<Character>[] blocks;

    public void solveSudoku(char[][] board) {
        int row = 9;
        int column = 9;
        rows = new HashSet[9]; // 行
        columns = new HashSet[9]; // 列
        blocks = new HashSet[9]; // 块
        for (int i = 0; i < 9; i++) rows[i] = new HashSet<>();
        for (int i = 0; i < 9; i++) columns[i] = new HashSet<>();
        for (int i = 0; i < 9; i++) blocks[i] = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rows[i].add(board[i][j]);
                columns[j].add(board[i][j]);
                blocks[i / 3 + j / 3].add(board[i][j]);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '.') {
                    dfs(board, i, j);
                    break;
                }
            }
        }
    }

    private boolean dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != '.') {
            return true;
        }
        for (char num = '1'; num <= '9'; num++) {
            if (!rows[i].contains(num) && !columns[j].contains(num) && !blocks[i / 3 + j / 3].contains(num)) {
                rows[i].add(num);
                columns[j].add(num);
                blocks[i / 3 + j / 3].add(num);
                if (!(dfs(board, i - 1, j) && dfs(board, i + 1, j) && dfs(board, i, j - 1) && dfs(board, i, j + 1))) {
                    rows[i].remove(num);
                    columns[j].remove(num);
                    blocks[i / 3 + j / 3].remove(num);
                    return false;
                }
            }
        }
        return true;
    }
}
