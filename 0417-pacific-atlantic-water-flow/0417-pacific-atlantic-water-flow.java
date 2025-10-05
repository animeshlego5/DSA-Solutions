class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        int[][] directions = {{1, 0}, {0, 1}, {-1,0}, {0,-1}};
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            dfs(i, 0, heights, pacific, rows, cols, directions);
            dfs(i, cols-1, heights, atlantic, rows, cols, directions);
        }
        for(int j = 0; j < cols; j++){
            dfs(0, j, heights, pacific, rows, cols, directions);
            dfs(rows-1, j, heights, atlantic, rows, cols, directions);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j]==true && atlantic[i][j]==true){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private void dfs(int i, int j, int[][]heights, boolean[][]visited, int rows, int cols, int[][]directions){
        visited[i][j] = true;
        int newX = 0;
        int newY = 0;
        for(int[] dir : directions){
            newX = dir[0] + i;
            newY = dir[1] + j;
            if(newY>=0 && newX >=0 && newY < cols && newX < rows && visited[newX][newY]!=true && (heights[newX][newY]>=heights[i][j])){
                dfs(newX, newY, heights, visited, rows, cols, directions);
            }
        }
    }
}