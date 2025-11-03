class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();

        char[] array = colors.toCharArray();
        int prev = 0;
        int result = 0;
        for(int i = 1; i < n; i++){
            if(array[i]==array[prev]){
                if(neededTime[prev]> neededTime[i]){
                    result += neededTime[i];
                } else {
                    result += neededTime[prev];
                    prev = i;
                }  
            } else {
                prev = i;
            }
        }
        return result;
    }
}