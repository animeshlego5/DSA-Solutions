class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
        int[] newinterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(newinterval);
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0]<=newinterval[1]){
                newinterval[1] = Math.max(newinterval[1], intervals[i][1]);
            } else {
                newinterval = intervals[i];
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}