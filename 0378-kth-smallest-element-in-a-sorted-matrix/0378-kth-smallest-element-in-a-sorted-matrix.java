class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int smallest = matrix[0][0];
        int largest = matrix[n-1][n-1];

        int start = smallest;
        int end = largest;
        while(start <=end){
            int mid = start + (end - start)/2;
            int x = totalSmaller(matrix, mid);

            if(k-1<x){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public int totalSmaller(int[][] matrix, int mid){
        int total = 0;
        for(int i = 0; i <matrix.length; i++){
            int s = 0;
            int e = matrix[i].length - 1;
            
            while (s<=e){
                int m = s + (e-s)/2;
                if(matrix[i][m] <= mid){
                    
                    s = m + 1;
                } else {
                    e = m -1;
                }
            }
            total+=s;
            
        }return total;
    }
}