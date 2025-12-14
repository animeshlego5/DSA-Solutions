class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1_000_000_007;
        long ans = 1;
        int prev = 0;
        int seats = 0;

        for(int i=0; i<corridor.length(); i++) {
            char ch = corridor.charAt(i);
            if(ch=='S') {
                seats++;
                if(seats > 2 && seats%2==1) {
                    ans = (ans * (i-prev))%mod;
                }
                prev = i;
            }
        }

        return seats > 1 && seats%2==0 ? (int)ans : 0;
    }
}