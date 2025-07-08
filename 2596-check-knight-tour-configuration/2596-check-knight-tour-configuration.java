class Solution {
    int[][] dirn = {{-2,-1},{-2,1},{2,-1},{2,1},{1,2},{-1,2},{1,-2},{-1,-2}};
    int n;
    public boolean checkValidGrid(int[][] grid) {
        n = grid.length;
        if(grid[0][0]!=0){
            return false;
        }
        return helper(grid, 0, 0, 1);
        
    }
    public boolean helper(int[][]grid, int r, int c, int index){
        if(n*n==index){
            return true;
        }
        for(int[] dir : dirn){
            int i = r+dir[0], j = c+dir[1];
            if(i>=0 && j>= 0 && i<n && j< n && grid[i][j]==index){
                if(helper(grid, i ,j,index+1))return true;
            }
        }
        return false;
    }
}