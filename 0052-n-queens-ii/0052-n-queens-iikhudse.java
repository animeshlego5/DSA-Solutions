class Solution {
    int res = 0;
    int n;
    public int totalNQueens(int n) {

        int[][]board = new int[n][n];
        this.n = n;
        helper(n, board, 0);
        return res;
    }
    public void helper(int n, int[][] board, int col){
        if(col==n){
            res+=1;
            return;
        }
        for(int r = 0; r<n; r++){
            if(isSafe(r, col, board)){
                board[r][col]=1;
                helper(n, board, col+1);
                board[r][col]=0;
            }
        }
        return;
    }
    public boolean isSafe(int row, int col, int[][] board){
        for(int i = 0; i < col; i++){
            if(board[row][i]==1)return false;
        }
        for(int i = row, j =col;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1)return false;
        }
        for(int i = row, j =col;i<n&&j>=0;i++,j--){
            if(board[i][j]==1)return false;
        }
        return true;
    }
}