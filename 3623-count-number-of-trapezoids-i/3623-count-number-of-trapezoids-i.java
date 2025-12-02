class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] p : points){
            map.put(p[1], map.getOrDefault(p[1], 0)+1);
        }

        List<Integer> yCord = new ArrayList<>(map.keySet());
        Collections.sort(yCord);

        List<Long> hPlanes = new ArrayList<>();
        for(int p : yCord){
            long count = map.get(p);
            if(count>=2){
                hPlanes.add(count * (count-1)/2);
            } else {
                hPlanes.add(0L);
            }
        }
        long prefix = 0;
        long result = 0;
        for(long l : hPlanes){
            result = (result + prefix * (l%MOD))%MOD;
            prefix = (prefix+l)%MOD;
        }
        return (int) result;
    }
}