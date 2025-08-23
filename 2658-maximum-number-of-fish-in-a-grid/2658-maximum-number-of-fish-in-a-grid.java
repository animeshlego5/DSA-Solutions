class Solution {
    
        int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] >0){
                    maxFish = Math.max(dfs(grid, i, j),maxFish);
                }
            }
        }
        return maxFish;
    }
    private int dfs(int[][]grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)return 0;
        int temp = grid[i][j];
        
        int fishes = grid[i][j];
        grid[i][j] = 0;
        for(int[] dir : directions){
            int r = dir[0];
            int c = dir[1];
            fishes+=dfs(grid, i + r, j + c);
        }
        // grid[i][j] = temp;
        return fishes;
    }
}