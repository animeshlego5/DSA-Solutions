class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start = 1; 
        int end = Integer.MIN_VALUE;
        int ans = -1;

        for (int i = 0; i<quantities.length;i++){
            if(end<quantities[i]){
                end = quantities[i];
            }
        }
        
        while (start <= end ){
            int mid = start + (end -start)/2;
            if(canBeDist(quantities, n , mid)){
                ans = mid;
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    static boolean canBeDist(int[] quantities, int n, int mid){
        
        for(int i = 0; i < quantities.length; i++){
            int current = quantities[i];
            if(mid!=0){
                int num = current/mid;
            n = n - num;
            if(current%mid!=0){
                n--;
            }}
        }
        if(n<0){
            return false;
        }
        return true;
    }
}