class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        //first check for first row
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                firstRowHasZero = true;
                break;
            }
        }

        //check for first column
        for(int i=0;i< m; i++){
            if(matrix[i][0]==0){
                firstColumnHasZero = true;
                break;
            }
        }

        //start from second row and second column
        for(int i=1; i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                   matrix[0][j]=0;
                }
            }
        }

        //set zeroes based on what we have marked
        for(int i=1; i<m ;i ++){
            for(int j=1;j<n;j++){
                if( matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        //handle first row
        if(firstRowHasZero){
            for(int i=0;i< n ;i++){
                matrix[0][i]=0;
            }
        }
        //handle first column
        if(firstColumnHasZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}