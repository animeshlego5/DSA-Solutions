class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        for(int i = 1; i<arr.length; i++){
            if(arr[0]>=arr[1]){
                return false;
            } 
            if(arr[i-1]<arr[i]){
                continue;
            } else if(arr[i-1]>arr[i]){
                while(i<arr.length){
                    if(arr[i-1]<=arr[i]){
                        return false;
                    }
                    i++;
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}