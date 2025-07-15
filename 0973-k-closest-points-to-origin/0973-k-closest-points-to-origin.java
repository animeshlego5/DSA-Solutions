class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->dist(b)-dist(a));
        for(int[] point : points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][]res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll();
        }
        return res;
    }
    private int dist(int[] points){
        int x = points[0];
        int y = points[1];
        return x*x + y*y;
    }
}