class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int gcd = 1;
        while(min>0 && max>0){
            if(max>min){
                max = max % min;

            } else {
                min = min % max;
            }            
        }
        if(max==0)gcd = min;
        else gcd = max;
        return gcd;
    }
}