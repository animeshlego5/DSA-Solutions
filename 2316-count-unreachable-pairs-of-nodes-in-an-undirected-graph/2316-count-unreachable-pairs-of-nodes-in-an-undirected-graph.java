class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[]visited = new boolean[n];
        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        long total = ((long)n * (n-1))/2;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int nodes = dfs(i, visited, adj);
                long pairs = ((long)nodes * (nodes-1))/2;
                total -= pairs;
            }
        }
        return total;
    }
    private int dfs(int u, boolean[]visited, List<List<Integer>> adj){
        visited[u] = true;
        int count = 1;
        for(int v : adj.get(u)){
            if(!visited[v]){
                count +=dfs(v, visited, adj);
            }
        }
        return count;
    }
}