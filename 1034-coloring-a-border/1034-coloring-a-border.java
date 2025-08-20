class Solution {
    private static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int original = grid[row][col];
        dfs(grid, original, row, col);
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(grid[i][j]<0)grid[i][j]=color;
            }
        }

        return grid;
    }
    private void dfs(int[][]grid, int original, int row, int col){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1 || grid[row][col]!=original)return;
        grid[row][col] = -original;
        int count = 0;
        for(int[]d : dir){
            int newRow = row + d[0];
            int newCol = col + d[1];

            if(newRow>=0 && newCol>=0 && newRow<=grid.length-1 && newCol<=grid[0].length-1 &&Math.abs(grid[newRow][newCol])==original)count++;
            dfs(grid, original, newRow, newCol);
        }
        if(count==4)grid[row][col] = original;
    }
}