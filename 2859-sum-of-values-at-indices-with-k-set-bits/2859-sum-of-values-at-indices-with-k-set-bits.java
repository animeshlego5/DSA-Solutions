class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        
        int ans = 0;
        int i = 0;
        for(int n : nums){
            int count = 0;
            int j = i;
            while(j>0){
                if((j&1)==1)count++;
                j=j>>1;
            }
            if(count==k){
                ans += n;
            }
            i++;
        }
        return ans;
    }
}