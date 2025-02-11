class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long number = n;
        if(number<0){
            number=-1 * number;
        }
        while (number>0){
            if((number&1)!=0){
                ans = ans * x;
            }
            x = x*x;
           number= number>>1;
        }
        if (n<0){
            ans = 1.0/ans;
        }
        return ans;
    }
}