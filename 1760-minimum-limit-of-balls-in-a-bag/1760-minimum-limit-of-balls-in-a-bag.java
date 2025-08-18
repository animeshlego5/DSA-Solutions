class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int right = 0;
        for(int num : nums){
            right = Math.max(num, right);
        }
        int left = 1;
        while(left<=right){
            int mid= left +(right-left)/2;
            if(canBeDivided(mid, nums, maxOperations)){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canBeDivided(int maxBalls, int[]nums, int maxOperations){
        int operations = 0;
        for(int num : nums){
            if((float)num/maxBalls>1){
                operations += (num-1)/maxBalls;
            }
        }
        return operations <= maxOperations;
    }
}