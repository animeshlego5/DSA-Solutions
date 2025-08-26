class Solution {
    public int totalHammingDistance(int[] nums) {
        if(nums.length==1)return 0;
        int left = 0;
        long ans = 0;
        int n = nums.length;
        
        for(int i=0; i <32; i++){
            int countOnes = 0;
            for(int num : nums){
                if((num & (1<<i))!=0){
                    countOnes++;
                }
            }
            int countZeroes = n - countOnes;
            ans += countZeroes * countOnes;
        } 
    return (int)ans;
    }
}