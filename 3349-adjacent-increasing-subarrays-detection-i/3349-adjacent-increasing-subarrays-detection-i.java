class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if(k<2)return true;
        int firstStart = 0;
        int firstEnd = k-1;
        int secondStart = k;
        int secondEnd = k + k - 1;
        while(secondEnd < nums.size()){
            int i = firstStart;
            boolean first = true;
            while(i + 1 < secondStart){
                if(nums.get(i)>=nums.get(i+1)){
                    first = false;
                    break;
                }
                i++;
            }
            int j = secondStart;
            boolean second = true;
            while(j + 1 < secondEnd + 1){
                if(nums.get(j)>=nums.get(j+1)){
                    second = false;
                    break;
                }
                j++;
            }
            firstStart++;
            firstEnd++;
            secondStart++;
            secondEnd++;
            if(first&second)return true;
        }
        return false;
    }
}