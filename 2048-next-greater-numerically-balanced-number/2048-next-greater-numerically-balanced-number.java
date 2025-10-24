class Solution {
    public int nextBeautifulNumber(int n) {
        String num = String.valueOf(n);
        int length = num.length();
        long[] count = new long[10];
        long result = generate(n,  count, 0, length);
        long nextLenResult = generate(0,  count, 0, length+1);
        if(result==0) result = nextLenResult;
        return (int)result;
    }
    private long generate(long n, long[] count, long current, long remaining){
        if(remaining==0){
            if(current>n){
                for(int d = 1; d <=9; d++){
                    if(count[d] >0 && count[d]!=d)return 0;
                }
                return current;
            }
            return 0;
        }
        long result = 0;
        for(int d = 1; d<=9 && result==0; d++){
            if(count[d]<d && d-count[d]<=remaining){
                count[d]++;
                result = generate(n, count, current*10+d, remaining - 1);
                count[d]--;
            }
        }
        return result;
    }
}