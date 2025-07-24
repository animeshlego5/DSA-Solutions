class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];

        // Pair queries with their original indices
        int[][] queryWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }

        // Sort intervals by start, and queries by value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);

        // One min-heap for all queries (store interval)
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> 
            (a[1] - a[0]) - (b[1] - b[0]));

        int i = 0; // Pointer to intervals
        for (int[] q : queryWithIndex) {
            int query = q[0];
            int idx = q[1];

            // Add intervals that start before or at query
            while (i < intervals.length && intervals[i][0] <= query) {
                minheap.offer(intervals[i]);
                i++;
            }

            // Remove intervals that end before query
            while (!minheap.isEmpty() && minheap.peek()[1] < query) {
                minheap.poll();
            }

            // Set result
            res[idx] = minheap.isEmpty() ? -1 : minheap.peek()[1] - minheap.peek()[0] + 1;
        }

        return res;
    }
}
