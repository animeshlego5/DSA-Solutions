class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int ans = 0;
        int prev1 = 2;
        int prev2 = 1;
        for(int state = 3; state<=n; state++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
