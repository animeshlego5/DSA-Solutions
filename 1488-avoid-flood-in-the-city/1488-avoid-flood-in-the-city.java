class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        List<Integer> dries = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(rains[i]==0){
                dries.add(i);
                result[i] = 1;
            } else {
                if(map.containsKey(rains[i])){
                    int lastFilled = map.get(rains[i]);
                    int index = -1;
                    for(int j = 0; j < dries.size(); j++){
                        if(dries.get(j)>map.get(rains[i])){
                            index = dries.get(j);
                            dries.remove(j);
                            break;
                        }
                    }
                    if(index == -1)return new int[0];
                    result[index] = rains[i];
                }
                map.put(rains[i], i);
                result[i] = -1;
            }
            
        }
        return result;
    }
}