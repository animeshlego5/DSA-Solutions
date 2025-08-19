class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int currentGCD = 0;
            for(int j = i; j < n; j++){
                currentGCD = gcd(currentGCD, nums[j]);
                if(currentGCD==k){
                    count++;
                } else if(currentGCD<k) {
                    break;
                }
            }
        }
        return count;
    }
    private static int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b, a%b);
    }
}