class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 2;
        while(i<arr.length){
            if(arr[i-2]<arr[i-1] && arr[i-1]>arr[i]){
                return i-1;
            }
            i++;
        }
        return i;
    }
}