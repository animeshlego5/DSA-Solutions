class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int m = grid.length;
        int n = grid[0].length;
        int oldColor = grid[row][col];

        dfs(grid,row,col,m,n,oldColor,color,new boolean[m][n]);
        return grid;
    }

    public void dfs(int[][] grid,int r,int c,int m,int n,int oldColor,int newColor,boolean[][] visited){

        visited[r][c] = true;
        
        int[] arr1 = {0,0,-1,1};
        int[] arr2 = {1,-1,0,0};

        for(int i=0;i<4;i++){
            
            int nr = r+arr1[i];
            int nc = c+ arr2[i];

            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] ){

                if(grid[nr][nc] == oldColor)
                    dfs(grid,nr,nc,m,n,oldColor,newColor,visited);
                else
                    grid[r][c] = newColor;

            }
            
            else if(nr<0 || nc<0 || nr>=m || nc>=n)
                grid[r][c] = newColor;
            
        }

    }
}