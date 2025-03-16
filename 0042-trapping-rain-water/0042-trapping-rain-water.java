class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lmax = height[l];
        int rmax = height[r];
        int area = 0;

        while (l < r) {
            if (height[l] > lmax) {
                lmax = height[l];
            }
            if (height[r] > rmax) {
                rmax = height[r];
            }
            if (lmax > rmax) {
                area = area + (rmax - height[r]);
                r--;
            } else {
                area = area + (lmax - height[l]);
                l++;
            }

        }
        return area;
    }
}