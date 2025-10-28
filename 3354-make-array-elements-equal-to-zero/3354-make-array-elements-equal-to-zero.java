class Solution {
    public int countValidSelections(int[] nums) {
        int[] prefix = new int[nums.length];
        int sum = 0;
        int idx = 0;
        
        for(int n : nums){
            sum += n;
            prefix[idx++] = sum; 
        }
        int selection = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0){
                if(prefix[nums.length-1]-prefix[i]==prefix[i]){
                    selection+=2;
                } else if (prefix[nums.length-1]-prefix[i]+1==prefix[i]){
                    selection++;
                } else if(prefix[nums.length-1]-prefix[i]==prefix[i]+1){
                    selection++;
                }
            }
        }
        return selection;
    }
}