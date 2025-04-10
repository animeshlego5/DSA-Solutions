class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length; //columns

        int r = 0;
        int c = m - 1;

        

        while(r<n && c>=0){
            int current = matrix[r][c];
            if(current==target) {
                return true;
            } else if(current<target){
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}