class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        long mod = 0;
        for(int i = 0; i < n; i++){
            int num = word.charAt(i) - '0';
            mod = (mod * 10 + num) % m;
            res[i] = (mod==0)?1:0;
        }
        return res;
    }
}