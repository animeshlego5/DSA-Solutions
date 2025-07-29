class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0)return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
        
        for(int card : hand){
            if(!map.containsKey(card))continue;
            while(map.containsKey(card-1)){
            card--;
            }
        for(int i = 0; i < groupSize; i++){
            if(!map.containsKey(card+i)){
                return false;
            }
            map.put(card+i, map.get(card+i)-1);
            if(map.get(card+i)==0){
                map.remove(card+i);
            }
        }
        
    }
    return true;
}
}