class Solution {
    public String minWindow(String str, String T) {
        int count = 0;
        int[] dict = new int[128];
        for (char c : T.toCharArray()) {
            if (dict[c] == 0) {
                count++;
            }
            dict[c]++;
        }

        char[] s = str.toCharArray();
        int left = 0, ansLeft = -1, ansRight = s.length;
        for (int right = 0; right < s.length; right++) {
            char c = s[right];
            dict[c]--;
            if (dict[c] == 0) {
                count--;
            }

            while (count == 0) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }

                if (dict[s[left]] == 0)
                    count++;

                dict[s[left]]++;
                left++;
            }
        }
        return ansLeft < 0 ? "" : str.substring(ansLeft, ansRight + 1);
    }
}