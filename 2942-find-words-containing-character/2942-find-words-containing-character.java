class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            for(char c : s.toCharArray()){
                if (c==x){
                    list.add(i);
                    break;}
            }
        }
        return list;
    }
}