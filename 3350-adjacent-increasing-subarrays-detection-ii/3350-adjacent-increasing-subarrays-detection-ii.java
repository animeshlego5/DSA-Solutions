class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int pl = 0; //previous length
        int cl = 1; //current length is 1 as 1 element is sorted
        int result = 0; //max length of increasing subarrays

        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i-1)<nums.get(i)){
                cl++;
            } else {
                pl = cl;
                cl = 1;
            }
            result = Math.max(result, Math.max(cl/2, Math.min(cl, pl)));
        }
        return result;
    }
}