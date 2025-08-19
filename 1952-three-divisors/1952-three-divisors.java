class Solution {
    public boolean isThree(int n) {
        if (n<4)return false;
        int count = 2;
        for(int i = 2; i * i <= n; i++){
            if(n%i==0){
                count++;
                if(i*i ==n)continue;
                else return false;
            }
        }
        return count==3;
    }
}