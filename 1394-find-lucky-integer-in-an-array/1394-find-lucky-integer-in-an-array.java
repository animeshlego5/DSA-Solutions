class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int findLucky(int[] arr) {
        int max = -1;
        for(int num:arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
                
                continue;
            }
            map.put(num,1);
        }
        for(int num:arr){
            if(map.get(num) == num){
                    max = Math.max(max, num);
                }
        }
        return max;
    }
}