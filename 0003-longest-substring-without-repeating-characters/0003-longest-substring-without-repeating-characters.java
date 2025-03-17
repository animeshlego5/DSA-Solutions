class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map <Character, Integer> map = new HashMap<>();
        int l = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                l = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            len = Math.max(len, i-l+1);
        }
        return len;
    }
}