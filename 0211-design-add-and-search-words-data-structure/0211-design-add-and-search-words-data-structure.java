class WordDictionary {
    List<String> dict;

    public WordDictionary() {
        dict = new ArrayList<>();
    }
    
    public void addWord(String word) {
        dict.add(word);
    }
    
    public boolean search(String word) {
        for (String w : dict) {
            if (w.length() != word.length()) {
                continue;
            }
            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != '.' && word.charAt(i) != w.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */