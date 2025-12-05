class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        int count = 0;
        int cur = 0;
        for(int i = 0; i < nums.length-1; i++){
            cur += nums[i];
            int partition = sum - cur;
            if((partition-cur)%2==0)count++;
        }
        return count;
    }
}