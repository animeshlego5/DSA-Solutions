class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] matrix = new char[m][n];

        int[][]dir = {{0,-1}, {0,1}, {1,0}, {-1,0}};
        for(int[] guard : guards){
            int x = guard[0], y = guard[1];
            matrix[x][y] = 'G';
        }
        for(int[] wall : walls){
            int x = wall[0], y = wall[1];
            matrix[x][y] = 'W';
        }
        for(int[] guard : guards){
            int x = guard[0], y = guard[1];
            for(int[] d : dir){
                dfs(x+d[0], y + d[1], matrix, m, n, d);
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]==0)count++;
            }
        }
        return count;
    }
    private void dfs(int x, int y, char[][]matrix, int m, int n, int[] d){
        if(x<0 || y<0 || x>=m || y>=n)return;
        if(matrix[x][y]=='G'||matrix[x][y]=='W')return;

        if(matrix[x][y]==0)matrix[x][y] = 'V';
        dfs(x+d[0], y + d[1], matrix, m, n, d);
    }
}