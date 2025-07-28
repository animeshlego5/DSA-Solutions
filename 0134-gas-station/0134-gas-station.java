class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalCost> totalGas)return -1;
        int curgas = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            curgas += gas[i] - cost[i];
            if(curgas<0){
                curgas = 0;
                start = i+1;
            }
        }
        return start;
    }
}