class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int monday = -1;
        for(int j = 0; j <n/7; j++){
            monday++;
            for(int i = 1; i <= 7; i++){
                total += monday + i;
            }
        }
        int i = n/7 + 1;
        int j = n%7;
        while(j>0){
            total+= i;
            i++;
            j--;
        }
        return total;
    }
}