class Solution {
    public boolean isPalindrome(int x) {
        int dup = x;
        int sign = 1;
        if(x<0){
           return false;
        }
        int rev = 0;
        while(x>0){
            rev = rev * 10 + x % 10;
            x = x/10;
        }
        if(rev==dup)return true;
        return false;
    }
}