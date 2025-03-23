class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] answer = new int[queries.length];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == x) {
                result.add(i);    
            } 
        }
        int j = 0;
        for(int i = 0; i < queries.length; i++) {
            if(result.size()>(queries[i]-1)){
                answer[j] = result.get((queries[i]-1));
                j++;
            } else {
                answer[j] = -1;
                j++;
            }
        }
        return answer;
    }
}