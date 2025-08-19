class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1)return false;
        int sum = 0;
        int dup = num;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num%i==0){
                sum += i;
                if(num/i!=num && num/i!=i){
                sum += num/i;
                }
            }
        }
        return sum==dup;
    }
}