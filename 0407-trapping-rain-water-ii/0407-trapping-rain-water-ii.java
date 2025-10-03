class Solution {
    private class Entry{
        int h, i, j;
        Entry(int h, int i, int j){
            this.h = h;
            this.i = i;
            this.j = j;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b)->a.h-b.h);
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i==0 || j==0 || i== rows-1 || j == cols-1){
                    visited[i][j] = true;
                    pq.offer(new Entry(heightMap[i][j], i, j));
                }
            }
        }
        int maxValue = 0;
        int result = 0;
        while(!pq.isEmpty()){
            Entry entry = pq.poll();
            maxValue = Math.max(maxValue, entry.h);

            
            for(int[] d: dirs){
                int newX = entry.i + d[0];
                int newY = entry.j + d[1];
                if(newX>=0 && newY>=0 && newX<rows &&newY<cols && !visited[newX][newY]){

                    int currentHeight = heightMap[newX][newY];
                    pq.offer(new Entry(currentHeight, newX, newY));
                    visited[newX][newY] = true;
                    if(currentHeight < maxValue){
                        result += maxValue - currentHeight;
                    }
                }
            }
        }
        return result;
    }
}