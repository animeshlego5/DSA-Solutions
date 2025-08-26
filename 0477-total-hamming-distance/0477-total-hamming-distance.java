class Solution {
    public int totalHammingDistance(int[] nums) {

        int ans = 0;
        int n = nums.length;
        
        for(int i=0; i <31; i++){
            int y = 0;
            for(int j = 0; j < n; j++){
                if((nums[j] & (1<<i))!=0){
                    y++;
                }
            }
            int x = n - y;
            ans += x * y;
        } 
    return ans;
    }
}