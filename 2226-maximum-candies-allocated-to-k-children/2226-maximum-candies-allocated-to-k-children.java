class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int right = 0;
        long sum = 0;
        int left = 1;
        for(int candy : candies){
            right = Math.max(right, candy);
            sum += candy;
        }
        if(k>sum)return 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(canGet(mid, candies, k)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    private boolean canGet(int maxCandy, int[] candies, long k){
        long total = 0;
        for (int candy : candies) {
            total += candy / maxCandy;
        }
        return total >= k;
    }
}