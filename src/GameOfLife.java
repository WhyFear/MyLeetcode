import java.util.Arrays;

/*
    https://leetcode-cn.com/problems/game-of-life/
    加和比较简单,类似于深度学习，在矩阵四周加上0
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] ip = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(ip);
    }

    public static void gameOfLife(int[][] board) {
        if(board.length < 1) return;
        int height = board.length + 2;
        int weight = board[0].length + 2;
        int[][] tmp = new int[height][weight];
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                tmp[i] = new int[weight];
            } else {
                for (int j = 0; j < weight; j++) {
                    if (j == 0 || j == weight - 1) {
                        tmp[i][j] = 0;
                    } else {
                        tmp[i][j] = board[i - 1][j - 1];
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(tmp));
        int result;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                result = tmp[x][y] + tmp[x][y + 1] + tmp[x][y + 2] + tmp[x + 1][y] + tmp[x + 1][y + 2] + tmp[x + 2][y] + tmp[x + 2][y + 1] + tmp[x + 2][y + 2];
                if (board[x][y] == 1) {
                    if (result < 2) {
                        board[x][y] = 0;
                    } else if (result == 2 || result == 3) {
                        board[x][y] = 1;
                    } else {
                        board[x][y] = 0;
                    }
                } else {
                    if (result == 3) {
                        board[x][y] = 1;
                    } else {
                        board[x][y] = 0;
                    }
                }
            }
        }
    }
}
