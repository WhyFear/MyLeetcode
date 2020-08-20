/**
 * https://leetcode-cn.com/problems/minesweeper/
 */
public class UpdateBoard {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E') {
            return;
        }
        // 八个方向
        int result = findMines(board, i - 1, j - 1) + findMines(board, i - 1, j) + findMines(board, i - 1, j + 1) +
                findMines(board, i, j - 1) + findMines(board, i, j) + findMines(board, i, j + 1) +
                findMines(board, i + 1, j - 1) + findMines(board, i + 1, j) + findMines(board, i + 1, j + 1);
        if (result == 0) {
            board[i][j] = 'B';
            // 八个方向
            dfs(board, i - 1, j - 1);
            dfs(board, i - 1, j);
            dfs(board, i - 1, j + 1);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
            dfs(board, i + 1, j - 1);
            dfs(board, i + 1, j);
            dfs(board, i + 1, j + 1);
        } else {
            board[i][j] = (char) (result + 48);
        }
    }

    private int findMines(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'M') {
            return 0;
        } else return 1;
    }
}
