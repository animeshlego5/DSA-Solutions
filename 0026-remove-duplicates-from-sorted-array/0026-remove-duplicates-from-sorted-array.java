class Solution {
    public int removeDuplicates(int[] nums) {
        int target = nums[0];
        int holder = 1;
        int k = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=target){
                target=nums[i];
                nums[holder++]=nums[i];
                k++;
            }

        }
    return k;}
}