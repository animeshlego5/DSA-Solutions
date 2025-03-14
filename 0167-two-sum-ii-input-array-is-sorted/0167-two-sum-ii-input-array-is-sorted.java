class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map <Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        for(int i = 0; i<n;i++){
            int difference = target - numbers[i];
            if(map.containsKey(difference)){
                return new int[]{map.get(difference)+1,i+1};
                
            }
            map.put(numbers[i],i);
        }
        return new int[]{};
    }
}