class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights==null || heights.length == 0)return new ArrayList<>();

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for(int i = 0; i < row; i++){
            dfs(i, 0, heights, pacific);
            dfs(i, col-1, heights, atlantic);
        }
        for(int i = 0; i < col; i++){
            dfs(0, i, heights, pacific);
            dfs(row-1, i, heights, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;

    }
    private void dfs(int row, int col, int[][]heights, boolean[][]bool){
        bool[row][col] = true;
        int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] dir :directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow<0 || newCol < 0 || newRow>=heights.length || newCol >= heights[0].length)continue;
            if(bool[newRow][newCol])continue;
            if(heights[newRow][newCol]<heights[row][col])continue;
            dfs(newRow, newCol, heights, bool);
        }
    }
}