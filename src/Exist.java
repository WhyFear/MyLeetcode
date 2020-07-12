/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 未剪枝，22ms 超过6%
 */
public class Exist {
    boolean[][] visited;
    boolean flag = false;
    int row, column, wordLen;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        column = board[0].length;
        wordLen = word.length() - 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[row][column];
                    try {
                        dfs(board, word, i, j, 0);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        }
        return flag;
    }

    private void dfs(char[][] board, String word, int i, int j, int wordIndex) throws Exception {
        if (board[i][j] != word.charAt(wordIndex) || visited[i][j]) {
            return;
        }
        if (wordIndex == wordLen) { //即相等也是最后一位，那么直接退出递归
            flag = true;
            throw new Exception("exit dfs");
        }

        visited[i][j] = true;
        if (i > 0) dfs(board, word, i - 1, j, wordIndex + 1);
        if (i < row - 1) dfs(board, word, i + 1, j, wordIndex + 1);
        if (j > 0) dfs(board, word, i, j - 1, wordIndex + 1);
        if (j < column - 1) dfs(board, word, i, j + 1, wordIndex + 1);
        visited[i][j] = false;
    }
}
