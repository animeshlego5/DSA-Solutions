class Solution {
    public int characterReplacement(String s, int k) {
        int[] ch = new int[26];
        int l = 0; 
        int maxf = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) { 
            ch[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, ch[s.charAt(r) - 'A']);
            while ((r - l + 1 - maxf) > k) {
                ch[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}