class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];
        int rowLength = image.length;
        int colLength = image[0].length;
        if(original==color)return image;
        dfs(image, sr, sc, original, color);
        return image;
    }
    private void dfs(int[][]image, int row, int col, int original, int color){
        if(row<0 || col <0 || row>=image.length || col>=image[0].length ||image[row][col]!=original)return;
        image[row][col] = color;
        for(int[] d : dir){
            int newRow = row + d[0];
            int newCol = col +d[1];
            if(newCol>=0 && newRow>=0 && newCol<image[0].length &&  newRow<image.length && image[newRow][newCol]==original){
                dfs(image, newRow, newCol, original, color);
            }
        }
    }
}
