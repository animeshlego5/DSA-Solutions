class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int res = n;
        int curr = 0;
        int need = 0;
        for(int num : nums){
            need = (need + num)%p;
        }
        if(need==0)return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            curr = (curr+nums[i])%p;
            map.put(curr, i);
            int want = (curr-need+p)%p;
            res= Math.min(res, i- map.getOrDefault(want, -n));
            
        }

        return res==n?-1:res;
    }
}