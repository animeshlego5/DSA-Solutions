class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for(int num : nums){
            left = Math.max(num, left);
            right +=num;
        }
        while(left<=right){
            int mid = left +(right- left)/2;
            if(partitions(mid, nums)>k){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public int partitions(int maxSum, int[]a){
        int n = a.length;
        int partitions = 1;
        int subarraySum = 0;
        for(int i = 0; i < n; i++){
            if(subarraySum + a[i] > maxSum){
                partitions++;
                subarraySum = a[i];
            } else {
                subarraySum += a[i];            }
        }
        return partitions;
    }
}