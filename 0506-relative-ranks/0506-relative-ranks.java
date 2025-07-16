class Solution {
    // class rank{
    //     int score;
    //     int rank;
    // }
    public int findMax(int score[]){
        int max = Integer.MIN_VALUE;
        for(int element:score){
            max = Math.max(max, element);
        }
        return max;
    }
    public String[] findRelativeRanks(int[] score) {
        int maxVal = findMax(score);
        int map[] = new int [maxVal + 1];
        int n =score.length;
        //fill in map
        for(int i = 0;i<score.length;i++){
            map[score[i]] = i + 1;
        }
        String res[] = new String[n];
        int rank = 1;
        for(int i =maxVal;i>=0;i--){
            if(map[i]!=0){
                int originalIndex = map[i]-1;
                if(rank==1){
                    res[originalIndex]="Gold Medal";
                } else if(rank==2){
                    res[originalIndex]= "Silver Medal";
                } else if(rank==3){
                    res[originalIndex]= "Bronze Medal";
                } else {
                    res[originalIndex]=Integer.toString(rank);
                }
                rank++;
            }
            if(rank>n)break;
        }
        return res;
    }
}