class Solution {
    public boolean judgeCircle(String moves) {
        char[]movesMade = moves.toCharArray();
        int row = 0;
        int col = 0;
        for(char move : movesMade){
            if(move=='U'){
            row += -1;
            } else if(move=='D'){
                row+=+1;
            } else if(move=='L'){
                col+=-1;
            } else{
                col+=+1;
            }
        }
        return (row==0 && col==0);
    }
}