class Solution {
    public int numSub(String s) {
        long result = 0;
        long mod = (long)Math.pow(10, 9)+7;
        long ones = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1'){
                ones++;
                continue;
            } else {
                result += (ones * (ones + 1))/2;
                ones = 0;
                result%=mod;
            }
        }
        result += (ones * (ones + 1))/2;
        result%=mod;
        return (int)result;
    }
}