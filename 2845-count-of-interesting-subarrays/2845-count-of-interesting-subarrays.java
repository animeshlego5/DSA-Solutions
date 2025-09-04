class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0;
        int count = 0;
        int size = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < size; i++){
            if(nums.get(i)%modulo==k){
                count++;
            }
            int rem = count % modulo;
            int remove = (rem%modulo -k)%modulo;
            res += map.getOrDefault(remove, 0);
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return res;
    }
}