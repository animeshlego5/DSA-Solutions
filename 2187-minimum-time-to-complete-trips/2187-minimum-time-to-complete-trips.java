class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int right = time[0];
        int left = 1;
        for(int times : time){
            right = Math.min(right, times);
        }
        right = totalTrips * right;
        while(left<right){
            int mid = left + (right - left)/2;
            if(canComplete(mid, time, totalTrips)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canComplete(int timeTaken, int[] time, int totalTrips){
        int total = 0;
        for(int times : time){
            total += timeTaken/times;
        }
        return total>=totalTrips;
    }
}