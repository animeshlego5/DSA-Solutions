class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count= 0;
        for (char c : jewels.toCharArray()){
            for(char s: stones.toCharArray()){
                if(c==s){
                    count++;
                }
            }
        }
        return count;
    }
}