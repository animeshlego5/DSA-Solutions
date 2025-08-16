class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum2 = 0;
        for (int n1 : nums) {
            sum2 += n1;
        }
        int sum1 = n * (n + 1) / 2;

    return sum1- sum2;   
    }
}