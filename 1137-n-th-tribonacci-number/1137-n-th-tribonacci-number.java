class Solution {
    public int tribonacci(int n) {
        if(n==0)return 0;
        if(n<=2)return 1;
        int ans = 0;
        int prev1 = 1;
        int prev2 = 1;
        int prev3 = 0;
        for(int state = 3; state<=n; state++){
            ans = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}