class Solution {
    public long minTime(int[] skill, int[] mana) {
       int n = skill.length;
       int m = mana.length;
       
       long[] f = new long[n];
       for(int i = 0; i < m; i++){
            int x = mana[i];
            long current = f[0];
           for(int j = 1; j < n; j++){
                current = Math.max(current + x * skill[j-1], f[j]);
           }
           f[n-1] = current + (long)skill[n-1] * x;
           for(int j = n - 2; j>=0; j--){
                f[j] = f[j+1] - (long)skill[j+1] * x;
           }
        } 
        return f[n-1];
    }
}