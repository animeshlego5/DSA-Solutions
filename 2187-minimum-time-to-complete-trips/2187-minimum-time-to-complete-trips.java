class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long right = time[0];
        long left = 1;
        for(int times : time){
            right = Math.min(right, times);
        }
        right = totalTrips * right;
        while(left<right){
            long mid = left + (right - left)/2;
            if(canComplete(mid, time, totalTrips)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canComplete(long timeTaken, int[] time, int totalTrips){
        long total = 0;
        for(int times : time){
            total += timeTaken/times;
            if (total >= totalTrips) {
                return true; // early stopping to avoid overflow
            }
        }
        return total>=totalTrips;
    }
}