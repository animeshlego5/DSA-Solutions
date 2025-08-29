class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];
        
        for(int[] log : logs){
            population[log[0]-1950]++;
            population[log[1]-1950]--;
        }
        int maxYear = 0;
        int currMax = 0;
        int curr= 0;
        for(int i = 0; i < 101; i++){
            curr += population[i];
            if(curr>currMax){
                maxYear = i + 1950;
                currMax = curr;
            }
        }
        return maxYear;
    }
}