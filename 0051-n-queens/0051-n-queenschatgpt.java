class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][]board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        helper(n,board, 0);
        return res;
    }
    public void helper(int n, char[][]board, int col){
        if(col==n){
            res.add(construct(board));
            return;
        }
        
        for(int r = 0; r<n; r++){
            if(isSafe(r, col, board, n)){
                board[r][col] = 'Q';
                helper(n, board, col+1);
                board[r][col] = '.';
            }
        }
        return;
    }
    public boolean isSafe(int row, int col, char[][]board, int n){
        //left of the row
        for(int i = 0; i < n; i++){
            if(board[row][i]=='Q')return false;
        }
        //upper left diag
        for(int i=row, j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }
        //bottom left diag
        for(int i=row, j=col;i<n&&j>=0;i++,j--){
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
    public List<String> construct(char[][]board){
        List<String> sol = new ArrayList<>();
        for(char[] row : board){
            sol.add(new String(row));
        }
        return sol;
    }
}