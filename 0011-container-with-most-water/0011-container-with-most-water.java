class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = heights.length - 1;
        int area = 0;
            while (l<r) {
                if ( heights [l] <= heights [r]) {
                    area = (r - l) * heights[l];
                    l++;
                } else if ( heights [l] > heights [r] ) {
                    area = (r - l) * heights[r];
                    r--;
                }
                max = Math.max(area, max);
            }
            return max;
    }
}
