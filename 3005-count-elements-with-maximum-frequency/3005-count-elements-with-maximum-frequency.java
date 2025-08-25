class Solution {
    public int maxFrequencyElements(int[] nums) {
        int elements = 1;
        int maxFrequency = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(maxFrequency<=value){
                if(maxFrequency==value){
                    elements++;
                } else {
                    elements = 1;
                }
                maxFrequency = value;  
            }
        }
        return maxFrequency * elements;
    }
}