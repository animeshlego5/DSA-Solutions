class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            if(manager[i]!=-1){
                adj.get(manager[i]).add(i);
            }
        }
        return dfs(headID, adj, informTime);
    }
    private int dfs(int current, List<List<Integer>> adj, int[] informTime){
        int maxTime = 0;
        for(int subordinate : adj.get(current)){
            maxTime = Math.max(maxTime, dfs(subordinate, adj, informTime));
        }
        return informTime[current] + maxTime;
    }
}