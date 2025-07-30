class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partition = new ArrayList<Integer>();
        int i = 0;
        while(i<s.length()){
            int start = i;
            int end = s.lastIndexOf(s.charAt(start));
            for(int j = start + 1; j < end; j++){
                char c = s.charAt(j);
                if(s.lastIndexOf(c)<=end){
                    continue;
                }
                end = s.lastIndexOf(c);
            }
            partition.add(end-start + 1);
            i = end + 1;
        }
        return partition;
    }
}