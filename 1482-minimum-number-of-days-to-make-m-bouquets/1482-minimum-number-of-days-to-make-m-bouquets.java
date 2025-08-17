class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // If there aren’t enough flowers to make m bouquets, return -1
        if (bloomDay.length < (long)m * k) return -1;

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        // Binary search the minimum day that makes m bouquets
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(mid, bloomDay, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canMake(int day, int[] bloomDay, int m, int k) {
        int bouquets = 0, flowers = 0;
        for (int d : bloomDay) {
            if (d <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
