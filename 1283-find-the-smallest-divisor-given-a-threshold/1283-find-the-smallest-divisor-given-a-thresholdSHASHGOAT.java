class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        int ans = -1;
        
        for(int i = 0; i <nums.length; i++){
            if(nums[i]>end){
                end = nums[i];
            }
        }

        while (start <= end){
            int mid = start + (end - start)/2;

            if(isDivisible(nums, threshold, mid)){
                ans = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    static boolean isDivisible(int[]nums, int threshold, int mid){
        int sum = 0;
        for (int i = 0; i <nums.length; i++){
            sum += nums[i]/mid;
            if(nums[i]%mid!=0){
                sum++;
            }
        }
        if(sum<=threshold){
            return true;
        }
        return false;
    }
}