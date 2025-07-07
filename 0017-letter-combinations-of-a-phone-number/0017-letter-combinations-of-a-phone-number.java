class Solution {
    List<String> res = new ArrayList<>();
        String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
        

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())return res;
        helper(digits, 0, new StringBuilder());
        // System.out.print(two[0]);
        // return new ArrayList<>();
        return res;
    }

    public void helper(String digits, int index, StringBuilder curr) {
        if(index==digits.length()){
            res.add(curr.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map[digit - '0'];
        for(char c : letters.toCharArray()){
            curr.append(c);
            helper(digits, index + 1, curr);
            curr.delete(curr.length()-1,curr.length());
        }
    }
}