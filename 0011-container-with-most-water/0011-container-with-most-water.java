class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int n = heights.length;
        int r = n - 1;
        int area = 0;
            while (l<r) {
                if ( heights [l] <= heights [r]) {
                    area = (r - l) * heights[l];
                    max = Math.max(area, max);
                    l++;
                } else if ( heights [l] > heights [r] ) {
                    area = (r - l) * heights[r];
                    max = Math.max(area, max);
                    r--;
                } 
                
            }
            return max;
    }
}
