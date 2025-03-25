class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        int ans = -1;

        for(int i = 0; i<piles.length; i++){
            if(piles[i]>end){
                end = piles[i];
            }
        }

        //Now we have th erange, so we will apply binary search
        while (start<=end){
            int mid = start + (end - start)/2;

            if(canBeEaten(piles, h, mid)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    static boolean canBeEaten(int[] piles, int h, int mid){
        int hourseaten = 0;
        for(int i = 0; i<piles.length; i++){
            hourseaten += piles[i]/mid;
            if(piles[i]%mid!=0){
                hourseaten++;
            }
            if(hourseaten>h){return false;}

        }
        return true;
    }
}