class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] answer = new int[];
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == x) {
                result.add(i);
            }
        }
        int j = 0;
        for(int i = 0; i < queries.length; i++) {
            if(result.contains(queries(i))){
                answer[j] = result()
            }
        }
    }
}