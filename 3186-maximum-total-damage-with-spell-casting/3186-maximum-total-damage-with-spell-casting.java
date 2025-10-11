class Solution {
    Map<Integer, Integer> map;
    List<Integer> values;
    Long[] dp;
    public long maximumTotalDamage(int[] power) {
        map = new HashMap<>();
        for(int p : power)map.put(p, map.getOrDefault(p, 0) + 1);
        values = new ArrayList<>(map.keySet());
        Collections.sort(values);

        dp = new Long[values.size()];
        return helper(0);
    }
    private long helper(int i){
        if(i>=values.size())return 0;

        if(dp[i]!=null)return dp[i];

        long pick = 1L * values.get(i) * map.get(values.get(i));
        int index = binary(values.get(i) + 2);
        pick += helper(index);

        long skip = helper(i+1);
        dp[i] = Math.max(pick, skip); 
        return  dp[i];
    }
    private int binary(int i){
        int l = 0, r = values.size();
        while(l<r){
            int mid = l + (r-l)/2;
            if(values.get(mid)>i){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}