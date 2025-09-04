class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0; 
        int right  = nums.size() - 1;
        int ans = 0;
        while(left < right){
            int sum = nums.get(left) + nums.get(right);
            if(sum<target){
                ans += right - left;
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}