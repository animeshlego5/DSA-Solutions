class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxf = 0;
        int maxlength = 0;
        for (int end = 0; end < s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(end)));
            int window = end - start + 1;
            while (window - maxf > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
                window--;
            }
            maxlength = Math.max(maxlength, window);

        }
        return maxlength;
    }
}