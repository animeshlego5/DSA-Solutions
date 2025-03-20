class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1>n2){
            return false;
        }

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(int i = 0; i < n1; i++){ //initialization window
           a1[s1.charAt(i) -'a']++;
           a2[s2.charAt(i) -'a']++;
        }
        if(isMatched(a1,a2)){
            return true;
        }

        for(int i = 0; i<n2-n1;i++){
            a2[s2.charAt(i)-'a']--;
            a2[s2.charAt(i+n1)-'a']++;
            if(isMatched(a1,a2)){
            return true;
        }
        }
        return false;
    }
    public boolean isMatched(int[] a1, int[] a2){
        for(int i = 0; i < 26; i++){
            if(a1[i]!=a2[i]){
                return false;
            }
            
        }
        return true;
    }
}