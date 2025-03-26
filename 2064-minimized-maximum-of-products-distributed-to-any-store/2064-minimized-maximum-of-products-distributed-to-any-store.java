class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start = 1; 
        int end = Integer.MIN_VALUE;
        int ans = -1;

        // Find the maximum quantity to set the upper bound for the binary search
        for (int quantity : quantities) {
            end = Math.max(end, quantity);
        }

        // Perform binary search between start and end
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canBeDist(quantities, n, mid)) {
                ans = mid;
                end = mid - 1;  // Try to minimize the maximum number
            } else {
                start = mid + 1;  // Increase the maximum number
            }
        }
        return ans;
    }

    static boolean canBeDist(int[] quantities, int n, int mid) {
        int count = 0;
        
        // Calculate how many people are needed to distribute all the quantities
        for (int quantity : quantities) {
            count += (quantity + mid - 1) / mid;  // This is equivalent to Math.ceil(quantity / mid)
            
            // Early exit if count exceeds n
            if (count > n) {
                return false;
            }
        }
        return count <= n;
    }
}
