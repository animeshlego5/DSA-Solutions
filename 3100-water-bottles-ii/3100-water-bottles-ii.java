class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        int empty = numBottles;
        int full = 0;
        while(empty + full>=numExchange || full>0){
            if(empty>=numExchange){
                full++;
                empty -= numExchange;
                numExchange++;
            } else if(full>0){
                empty += full;
                result += full;
                full = 0;
            }
        }
        return result;
    }
}