class Solution {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int n, m;
    private int changeTo;
    
    public void dfs(int x, int y, int[][] grid, int color, boolean[][] vis){
        vis[x][y] = true;
        boolean boundaryCell = false;
        
        int nx, ny;
        for(int d=0; d<4; d++){
            nx = x + dx[d];
            ny = y + dy[d];
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