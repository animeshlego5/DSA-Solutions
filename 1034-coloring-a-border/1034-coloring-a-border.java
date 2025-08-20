class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int n, m;
    private int changeTo;
    
    public void dfs(int x, int y, int[][] grid, int color, boolean[][] vis){
        vis[x][y] = true;
        boolean boundaryCell = false;
        
        int nx, ny;
        for(int[]d : dir){
            nx = x + d[0];
            ny = y + d[1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || (!vis[nx][ny] && grid[nx][ny] != color)){
                grid[x][y] = changeTo;
                continue;
            }
            if(!vis[nx][ny])
                dfs(nx, ny, grid, color, vis);
        }      
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        n = grid.length; m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        changeTo = color;
        dfs(row, col, grid, grid[row][col], vis);
        return grid;
    }
}