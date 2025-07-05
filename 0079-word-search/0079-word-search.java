class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m;i++){
            for(int j = 0; j<n; j++){
               if(board[i][j]==word.charAt(0)){
                boolean found = helper(board, word, i ,j, 0);
                if(found)return true;
               }
            }
        }
        return false;
    }
    public boolean helper(char[][]board, String word, int row, int col, int wordIndex){
        if(wordIndex == word.length())return true;
        int r = board.length;
        int c = board[0].length;
        if(row<0||col<0||row>=r||col>=c)return false; //out of bound cases
        if(board[row][col]=='$'||board[row][col]!=word.charAt(wordIndex))return false;//visited character

        //mark as visited
        char ch = board[row][col];
        board[row][col]='$';

        //dfs
        if(helper(board, word, row, col+1, wordIndex+1)||helper(board, word, row, col-1, wordIndex+1)||helper(board, word, row+1, col, wordIndex+1)||helper(board, word, row-1, col, wordIndex+1)){
            return true;
        }
        //backtracking
        board[row][col]=ch;
        return false;
    }
}