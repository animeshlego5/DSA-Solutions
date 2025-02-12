class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        for(int j =nums.length-1;j>=nums.length-count;j--){
            nums[j] = 0;
        }
    }
}