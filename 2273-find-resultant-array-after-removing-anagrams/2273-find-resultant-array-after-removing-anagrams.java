class Solution {
    public List<String> removeAnagrams(String[] words) {
        int prev = 0; int curr = 1;
        List<String> result = new ArrayList<>();
        result.add(words[prev]);
        while(curr<words.length){
            if(!isAnagram(words[curr], words[prev])){
                result.add(words[curr]);
                prev = curr;
            }
            curr++;
        }
        return result;
    }
    private boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())return false;
        int[] c1 = new int[26];
        
        for(char c : s1.toCharArray()){
            c1[c-'a']++;
        }
        for(char c : s2.toCharArray()){
            c1[c-'a']--;
        }
        for(int i : c1){
            if(i!=0)return false;
        }
        return true;
    }
}