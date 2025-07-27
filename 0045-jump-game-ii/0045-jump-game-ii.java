class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int lastindex = 0;
        int jumps = 0;
        int coverage = 0;
        for(int i = 0; i < nums.length; i++){
            coverage = Math.max(coverage, nums[i] + i);
            if(i==lastindex){
                jumps++;
                lastindex = coverage; 
            }
            if(coverage>=nums.length-1)return jumps;
        }
        return jumps;

    }
}