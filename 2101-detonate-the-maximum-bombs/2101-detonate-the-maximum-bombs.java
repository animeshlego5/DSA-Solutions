class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans = 0; 
        for(int i = 0; i < bombs.length; i++){
            ans = Math.max(ans, dfs(bombs, i, new boolean[bombs.length]));
        }
        return ans;
    }
    private int dfs(int[][]bombs, int idx, boolean[]visited){
        visited[idx] = true;
        int count = 0;
        for(int i = 0; i < bombs.length; i++){
            if(!visited[i] && inRange(bombs[idx],bombs[i])){
                count+=dfs(bombs, i, visited);
            }
        }
        return 1 + count;
    }
    private boolean inRange(int[] a, int[] b){
        int dx = a[0]-b[0], dy = a[1]-b[1], r=a[2];
        return dx * dx + dy * dy <= r * r;
    }
}