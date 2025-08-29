class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] parked = new boolean[101];
        for(List<Integer> num : nums){
            int start = num.get(0);
            int end = num.get(1);
            for(int i = start; i <= end; i++){
                parked[i] = true;
            }
        }
        int count = 0;
        for(boolean answer : parked){
            if(answer){
                count++;
            }
        }
        return count;
    }
}