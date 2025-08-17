class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int n = arr.length;
        int right = n-1;
        while(left <= right) {
            int  mid  = left + (right - left)/2;
            if(k<=(arr[mid]-mid-1)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return k + right + 1;
    }
}