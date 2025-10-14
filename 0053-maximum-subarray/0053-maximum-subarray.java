class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int ansStart = -1;
        int ansEnd = -1;
        int start = 0;

        for(int i = 0; i < nums.length; i++){
            if(sum==0)start = 0;
            sum+=nums[i];
            if(max<sum){
                    max = sum;
                    ansEnd = i;
                    ansStart = start;
                }
            if(sum<0){
                sum = 0;
            } 
                
            
        }
        return max;
    }
}