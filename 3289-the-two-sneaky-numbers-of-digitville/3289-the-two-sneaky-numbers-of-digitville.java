class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int[] freq = new int[102];
        for(int n : nums){
            if(freq[n]==1){
                if(res[0]>0){
                    res[1] = n;
                } else {
                    res[0] = n;
                }
            }
            freq[n]++;
        }
        return res;
    }
}