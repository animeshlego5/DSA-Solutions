class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map = new int[k];
        map[0] = 1;
        int sum = 0;
        int count = 0;
        for(int i = 0; i <nums.length; i++){
            sum += nums[i];
            
            int rem = (sum%k);
            if(rem<0){
                rem = rem%k + k;
            }
            count += map[rem];
            map[rem]++;
        }
        return count;
    }
}