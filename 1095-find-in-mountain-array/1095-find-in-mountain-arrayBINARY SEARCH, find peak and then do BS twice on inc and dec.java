class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find peak index
        int n = mountainArr.length();
        int start=0;
        int end=n-1;
        int mid=-1;
        while(start<=end){
            mid = start + (end-start)/2;
            int cur = mountainArr.get(mid);
            if(mid!=0 && mid!=n-1 && cur>mountainArr.get(mid-1) 
            && cur >mountainArr.get(mid+1)){
                if(cur==target){
                    return mid;
                }
                break;
            }else if(mid!=n-1 && cur<mountainArr.get(mid+1)){ //inc
                start = mid+1;
            }else{ //dec
                end = mid-1;
            }
        }
        // find in first half (increasing)
        start = 0;
        end = mid-1;
        while(start<=end){
            int m = start + (end-start)/2;
            int cur = mountainArr.get(m);
            if(cur==target){
                return m;
            }else if(target<cur){
                end=m-1;
            }else{
                start=m+1;
            }
        }

        // find in second half (decreasing array)
        start = mid+1;
        end = n-1;
        while(start<=end){
            int m = start + (end-start)/2;
            int cur = mountainArr.get(m);
            if(cur==target){
                return m;
            }else if(target<cur){
                start=m+1;
            }else{
                end=m-1;
            }
        }
        return -1;
    }
}