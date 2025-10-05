class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[][]visited = new boolean[200][200];
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(visited[i][j]){
                    helper(i, j, matrix);
                }
            }
        }
        return;
    }
    private void helper(int row, int col, int[][]matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i==row || j==col){
                    matrix[i][j]=0;
                }
            }
        }
        return;

    }
}