class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        for(int num : nums){
            arr[num]++;
        }
        int maxFreq = 0;
        int res = 1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxFreq){
                maxFreq = arr[i];
                res =  1;
            } else if (arr[i] == maxFreq){
                res++;
            } else {
                continue;
            }
        }
        return res * maxFreq;
    }
}