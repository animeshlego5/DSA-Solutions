class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxNum = 0;
        for(int num : nums){
            if(maxNum<num){
                maxNum = num;
            }
        }
        int[] count = new int[maxNum + 2 + k];
        for(int num : nums){
            count[num]++;
        }

        int[] prefix = new int[count.length];
        prefix[0] = count[0];
        for(int i = 1; i < count.length; i++){
            prefix[i] = prefix[i-1] + count[i];
        }
        int ans = 0;
        for(int i = 0; i < count.length - k;i++){
            int left = Math.max(0, i-k-1);
            int right = Math.min(i+k, prefix.length - 1);
            int mid = count[i];

            int convertibleAmount = prefix[right] - prefix[left] - mid;

            if(convertibleAmount > numOperations){
                ans = Math.max(ans, mid + numOperations);
            } else {
                ans = Math.max(ans, mid + convertibleAmount);
            }
        }
        return ans;
    }
}