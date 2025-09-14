class Solution {
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int num : nums){
            if(num<l)l = num;
            if(num>r)r = num;
        }
        while(l<r){
            int mid = l + (r-l)/2, steal = 0;
            for(int i = 0; i < nums.length; ){
                if(nums[i]<=mid){steal++; i+=2;}
                else i++;
            }
            if(steal>=k)r = mid;
            else l = mid + 1;
        }
        return l;
    }
}