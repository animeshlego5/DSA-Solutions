class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0; 
        int right = length - 1;
        int lmax = height[left];
        int rmax = height[right];
        int result = 0;
        while(left<right){
            result = Math.max(result, Math.min(lmax, rmax) * (right - left));
            if(height[left]<height[right]){
                left++;
                lmax = Math.max(lmax, height[left]);
            } else {
                right--;
                rmax = Math.max(rmax, height[right]);
            }
        }
        return result;
    }
}