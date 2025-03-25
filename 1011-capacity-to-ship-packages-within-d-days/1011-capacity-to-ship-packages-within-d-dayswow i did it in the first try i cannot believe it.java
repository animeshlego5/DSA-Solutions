class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        int ans = -1;
        for(int i = 0; i < weights.length; i++){
            if (weights[i]>start){
                start = weights[i];
            }
            end += weights[i];
        }
        //Now we have the range 
        while (start<=end) {
            int mid = start + (end - start)/2;
            if (canBeShipped(weights, days, mid)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    static boolean canBeShipped(int[] weights, int days, int mid) {
        int mindays = 1;
        int weight = 0;
        for(int i = 0 ; i < weights.length; i++){
            weight += weights[i];
            if(weight > mid){
                mindays++;
                if(mindays>days){
                    return false;
                }
                weight = weights[i];
            }
            
        }
        return true;
    }
}