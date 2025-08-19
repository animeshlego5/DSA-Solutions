class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[n];
        int halfLength = (intLength + 1)/2;
        long start = (long)Math.pow(10, halfLength - 1);
        long end = (long)(Math.pow(10, halfLength)-1);

        for(int i = 0; i < n; i++){
            long firstHalf = start + queries[i] - 1;
            if(firstHalf>end){
                ans[i] = -1;
            } else {
                String firstHalfStr = Long.toString(firstHalf);
                String secondHalfStr = new StringBuilder(firstHalfStr).reverse().toString();
                if(intLength % 2 == 1){
                    secondHalfStr = secondHalfStr.substring(1);
                }
                ans[i] = Long.parseLong(firstHalfStr + secondHalfStr);
            }
        }
        return ans;
    }
}