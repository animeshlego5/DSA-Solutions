class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int row = 0;
        int underscore = 0;
        int distance =0;

        for(char move : moves.toCharArray()){
            if(move=='L'){
                row-=1;
            } else if(move=='R'){
                row+=1;
            } else if(move=='_'){
                underscore++;
            }

            
        }
        distance = Math.max(distance, Math.abs(row));
        return distance + underscore;
    }
}