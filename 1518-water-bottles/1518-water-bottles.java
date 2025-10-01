class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = 0;
        while(numBottles+empty>=numExchange){
            int recycle = (numBottles + empty) / numExchange;
            empty = (numBottles + empty) % numExchange;
            total += recycle;
            numBottles = recycle;
        }
        return total;
    }
}