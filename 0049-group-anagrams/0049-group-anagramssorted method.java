class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> res = new HashMap<>();
        for(String s : strs){
            char[] chararray = s.toCharArray();
            Arrays.sort(chararray);
            String sorted = new String(chararray);
            res.putIfAbsent(sorted, new ArrayList<>());
            res.get(sorted).add(s);

        }
        return new ArrayList<>(res.values());
    }
}