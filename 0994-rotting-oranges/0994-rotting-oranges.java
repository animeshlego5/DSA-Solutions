class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]==1){
                    freshOranges++;
                } else if(grid[i][j]==2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        if(freshOranges==0)return 0;

        int time = 0;
        while(!queue.isEmpty()){
            
            
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                int[][] neighbours = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
                if(grid[r][c]==2){
                    for(int[] neighbour : neighbours){
                        int nr = r + neighbour[0];
                        int nc = c + neighbour[1];
                        if(nc>=0 && nr>=0 && nr < row && nc < col && grid[nr][nc]!=2 && grid[nr][nc]!=0){
                            freshOranges--;
                            grid[nr][nc] = 2;
                            queue.offer(new int[]{nr, nc});
                        }
                        if(freshOranges==0)return ++time;
                    }
                }        
            }
            time++;
        }
        return -1;
    }
}