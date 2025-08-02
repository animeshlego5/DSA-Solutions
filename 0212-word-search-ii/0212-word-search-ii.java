class Solution {
    public class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for(String s : words){
            TrieNode node = root;
            for(char c : s.toCharArray()){
                if(node.children[c-'a']==null){
                    node.children[c-'a']= new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = s;
        }

        //res
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for(int i =0; i <m; i++){
            for(int j = 0; j < n; j++){
                dfs(res, i, j, board, root);
            }
        }
        return res;
    }
    private void dfs(List<String> res, int i, int j, char[][]board, TrieNode node){
        char c = board[i][j];
        if( c=='#' || node.children[c-'a']==null)return;
        node = node.children[c-'a'];
        if(node.word!=null){
            res.add(node.word);
            node.word=null;
        }
        board[i][j] = '#'; // Mark as visited
        if (i > 0) dfs(res, i - 1, j, board, node);
        if (j > 0) dfs(res, i, j - 1, board, node);
        if (i < board.length - 1) dfs(res, i + 1, j, board, node);
        if (j < board[0].length - 1) dfs(res, i, j + 1, board, node);
        board[i][j] = c; 
    }

}