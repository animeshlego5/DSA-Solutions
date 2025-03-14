class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        for(int i = 0;i<nums.length;i++){
            res[i] = prefix;
            prefix = prefix * nums[i];
        }
        for(int j = nums.length-1;j>=0;j--){
            res[j] = res[j] * postfix;
            postfix = postfix * nums[j];

        }
        return res;
}
}