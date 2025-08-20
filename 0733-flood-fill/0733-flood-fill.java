class Solution {
    int delrow[]={-1,0,+1,0};
    int delcol[]={0,+1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];
        if(original==color)return image;
        dfs(image, sr, sc, original, color);
        return image;
    }
    private void dfs(int[][]image, int row, int col, int original, int color){
        int n=image.length;
        int m=image[0].length;
        image[row][col] = color;
        for(int i = 0; i < 4; i++){
            int newRow = row + delrow[i];
            int newCol = col +delcol[i];
            if(newCol>=0 && newRow>=0 && newCol<m &&  newRow<n && image[newRow][newCol]==original){
                dfs(image, newRow, newCol, original, color);
            }
        }
    }
}
