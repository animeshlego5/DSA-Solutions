
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // If s1 is longer than s2, no permutation can exist
        if (n > m) return false;

        // Frequency map for characters in s1
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sliding window frequency map for s2
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;

        while (right < m) {
            char c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If the window size exceeds n, remove the leftmost character
            if (right - left + 1 > n) {
                char leftChar = s2.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }
                left++;
            }

            // Check if the window matches the map
            if (right - left + 1 == n && window.equals(map)) {
                return true;
            }

            right++;
        }

        return false;
    }
}
