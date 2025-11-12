class Solution {
    public int minOperations(int[] nums) {
        int overallGCD = nums[0];
        for(int num : nums){
            overallGCD = gcd(overallGCD, num);
        }
        if(overallGCD>1)return -1;
        int ones = 0;
        for(int num : nums){
            if(num==1){
                ones+=1;
            }
        }
        int min = Integer.MAX_VALUE;
        if(ones>1)return nums.length -ones;
        for(int i = 0; i < nums.length; i++){
            int g= nums[i];
            for(int j = i; j < nums.length; j++){
                g = gcd(g, nums[j]);
                if(g==1){
                    min = Math.min(min, j - i);
                    break;
                }    
            }
        } 
        return min + nums.length - 1;
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
}