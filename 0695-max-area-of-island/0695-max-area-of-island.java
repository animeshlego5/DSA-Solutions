class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length == 0 || grid[0].length==0) return 0;
        int max = Integer.MIN_VALUE;
        int[] count = {0};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                dfs(i, j, grid, count);
                max = Math.max(count[0], max);
                count[0] = 0;
            }
        }
        return max;
    }
    private void dfs(int i, int j, int[][]grid, int[] count){
        if(i<0 || j < 0 || i>=grid.length || j>= grid[0].length || grid[i][j]==0)return;
        count[0]++;
        grid[i][j]=0;
        dfs(i-1, j, grid, count);
        dfs(i+1, j, grid, count);
        dfs(i, j-1, grid, count);
        dfs(i, j+1, grid, count);
    }
}