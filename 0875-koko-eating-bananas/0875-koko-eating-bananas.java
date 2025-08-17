class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Integer.MIN_VALUE;
       for(int i : piles){
        if(i>right)right=i;
       }
       int left = 1; 
        
       while(left<right){
        int mid = left + (right - left)/2;
            if(canEat(mid, piles, h)){
                right = mid;
            } else {
                left = mid + 1;
            }
       }
       return left;
    }
    private boolean canEat(int bananas, int[] piles, int h){
        int hours = 0;
        for(int pile : piles){
            hours += (int)Math.ceil((double)pile/bananas);
            if(hours>h)return false;
        }
        return h>=hours;
    }
}