/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 * dfs 超时
 * 解法看下面
 */
public class Solve {
    int row;
    int column;
    boolean[][] visited;

    public void solve(char[][] board) {
        row = board.length;
        if (row < 1) return;
        column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                visited = new boolean[row][column];
                if (board[i][j] == 'O') {
                    if (dfs(board, i, j)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private boolean dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || visited[i][j]) return true; //边界外
        visited[i][j] = true;
        if (board[i][j] == 'O' && ((i == 0 || i == row - 1) || (j == 0 || j == column - 1))) //边界上且等于O
            return false;
        if (board[i][j] == 'X') return true;
        return dfs(board, i + 1, j) && dfs(board, i - 1, j) && dfs(board, i, j + 1) && dfs(board, i, j - 1);
    }
}
/*
java 5ms 首先对边界上每一个'O'做深度优先搜索，将与其相连的所有'O'改为'-'。然后遍历矩阵，将矩阵中所有'O'改为'X',将矩阵中所有'-'变为'O'
    int row,col;
    public void solve(char[][] board) {
        if(board==null||board.length==0)
            return ;
        row=board.length;
        col=board[0].length;
        for(int i=0;i<row;i++){
                dfs(board,i,0);
                dfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
                dfs(board,0,j);
                dfs(board,row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='-')
                    board[i][j]='O';
            }
        }
        return ;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=row||j>=col||board[i][j]!='O')
            return;
        board[i][j]='-';
            dfs(board,i-1,j);
            dfs(board,i+1,j);
            dfs(board,i,j-1);
            dfs(board,i,j+1);
        return ;
    }
 */
