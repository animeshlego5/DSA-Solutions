class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)return intervals;

        //sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));

        List<int[]> res = new ArrayList<>();

        int[] newInterval = intervals[0];
        res.add(newInterval);

        for(int[] interval : intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}