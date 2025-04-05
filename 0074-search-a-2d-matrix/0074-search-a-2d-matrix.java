class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length;
        int start = 0;
        int end = matrix.length * column - 1;
        while (start<=end){
            int mid = start + (end - start)/2;
            
            int current = matrix[mid/column][mid%column];
            
            if(current==target){
                return true;
            } else if (target>current){
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return false;
    }
}