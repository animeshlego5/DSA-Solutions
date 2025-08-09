class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        int rows = grid.length, cols = grid[0].length;
        int[][] time = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        int day = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, time, i, j, day);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE)
                        return -1;
                    res = Math.max(res, time[i][j]);
                }
            }
        }
        return res;

    }

    private void dfs(int[][] grid, int[][] time, int i, int j, int day) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != 0 && day<time[i][j]) {
            time[i][j] = day;
            dfs(grid, time, i + 1, j, day + 1);
            dfs(grid, time, i - 1, j, day + 1);
            dfs(grid, time, i, j + 1, day + 1);
            dfs(grid, time, i, j - 1, day + 1);
        }
    }
}