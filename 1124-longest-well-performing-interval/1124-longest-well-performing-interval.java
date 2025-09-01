class Solution {
    public int longestWPI(int[] hours) {
        int tiring= 0;
        int easy = 0;
        int[] nums = new int[n];
        for(int hour : hours){
            if(hour>8)tiring++;
            else easy++;
        }
        
        if(tiring>easy)return n;
        start = 0;
        end = n - 1;
        int ans = 0;
        while(start<=end){
            int s = hours[start];
            int e = hours[end];
            if(s>8){

            }
        }
        return ans;
    }
}