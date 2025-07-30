public class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // c == '*'
                low--;   // treat '*' as ')'
                high++;  // treat '*' as '('
            }
            if (high < 0)
                return false;
            if (low < 0)
                low = 0; // cannot have negative open parentheses
        }
        return low == 0;
    }
}
