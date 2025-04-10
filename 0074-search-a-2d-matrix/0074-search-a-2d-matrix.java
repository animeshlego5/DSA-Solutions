class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int end = m*n-1;

        while(start<=end){
            int mid = start + (end -start)/2;
            if(target==matrix[mid/m][mid%m]){
                return true;
            } else if(target>matrix[mid/m][mid%m]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}