class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            result.add(generateRow(i));
        }
        return result;
    }
    private List<Integer> generateRow(int row){
        int ans = 1;
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        for(int i = 1; i < row; i++){
            ans = ans * (row-i);
            ans = ans / i;
            answer.add(ans);
        }
        return answer;
    }

}