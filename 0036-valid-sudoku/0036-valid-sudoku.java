class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
            if(!seen.add(board[i][j] + "seen in row" + i) ||
               !seen.add(board[i][j] + "seen in column" + j) ||
               !seen.add(board[i][j]+"seen in box" + i/3 + "-" + j/3)){
                return false;
               }
            }
        }
        return true;
    }
}