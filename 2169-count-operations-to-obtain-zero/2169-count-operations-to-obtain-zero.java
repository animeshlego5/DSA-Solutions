class Solution {
    public int countOperations(int num1, int num2) {
        return helper(num1, num2, 0);
    }
    private int helper(int num1, int num2, int operations){
        if(num1==0 || num2==0)return operations;
        if(num1>num2){
            num1-=num2;
        } else{
            num2-=num1;
        }
        return helper(num1, num2, operations+1);
    }
}