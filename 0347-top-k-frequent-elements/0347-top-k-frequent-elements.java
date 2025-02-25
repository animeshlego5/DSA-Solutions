class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i,(count.getOrDefault(i,0)+1));
        }
        List<Integer> [] res = new List[nums.length+1];
        for(int i = 0;i<res.length;i++){
            res[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry:count.entrySet()){
            res[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for(int i = res.length-1;i>=0&&index<k;i--){
            for(int n :res[i]){
            result[index++]=n;
            if(index==k){
                return result;
            }
            }
        }

        return result;
    }
    
}