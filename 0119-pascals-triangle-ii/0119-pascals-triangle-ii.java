class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        long ans = 1;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for(int i = 1; i < rowIndex; i++){
            ans *= rowIndex - i;
            ans /= i;
            result.add((int)ans);
        }
        return result;
    }
}