class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, i, visited);
                provinces++;
            }
        }
        return provinces;
    }
    private void bfs(int[][]isConnected, int node, boolean[]visited){
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        int size = isConnected.length;
        while(!queue.isEmpty()){
            int city = queue.poll();
            for(int i = 0; i < size; i++){
                if(isConnected[city][i]==1 && !visited[i]){
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
    }
    private void dfs(int[][]isConnected, int start, boolean[]visited){
        visited[start] = true;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[start][i]==1 && !visited[i]){
                dfs(isConnected, i, visited);
            }
        }
    }
}