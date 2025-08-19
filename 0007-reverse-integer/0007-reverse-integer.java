class Solution {
    public int reverse(int x) {
        long rev = 0;
        int sign = 1;
        if(x<0){
            sign = -1;
            x = x * sign;
        }
        
        
        while(x>0){
            int lastDigit = x % 10;
            x = x/10;
            rev = (rev * 10) + lastDigit;
        }
        int max = Integer.MAX_VALUE;
        if(rev > max)return 0;
        return  sign * (int)rev;
    }
}