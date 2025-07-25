class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];

        Integer[] indexes = new Integer[n];
        for(int i = 0; i < n; i++){
            indexes[i]=i;
        }
        Arrays.sort(indexes, (a,b)->intervals[a][0]-intervals[b][0]);
        int i = 0;
        for(int[] interval : intervals){
            int end = interval[1];
            int left = 0, right = n-1;
            
            int ind = -1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(end<=intervals[indexes[mid]][0]){
                    ind = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i++] = (ind==-1)? -1:indexes[ind];
        }
        return res;
    }
}