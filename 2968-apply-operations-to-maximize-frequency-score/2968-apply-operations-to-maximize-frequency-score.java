

class Solution {
    
    private boolean isPossible(int length, int[] nums, long k, long[] prefixSum) {
        
        int leftIdx = 0, rightIdx = 0;
        while(rightIdx < nums.length) {
            if(rightIdx - leftIdx + 1 < length) {
                rightIdx++;
                continue;
            }
            
            int medianIdx = leftIdx + ((rightIdx - leftIdx) / 2);
            long curOperations = (prefixSum[rightIdx + 1] - prefixSum[medianIdx + 1]);
            if(medianIdx > leftIdx) {
                curOperations -= prefixSum[medianIdx] - prefixSum[leftIdx];
            }
            
            if((rightIdx - leftIdx + 1) % 2 == 0) {
                curOperations -= nums[medianIdx];
            }
            
            if(curOperations <= k) {
                return true;
            }
            
            
            leftIdx++;
            rightIdx++;
        }
        
        return false;
    }
    
    public int maxFrequencyScore(int[] nums, long k) {        
        
        if(nums.length == 1) {
            return 1;
        }
        
        Arrays.sort(nums);
        
        long[] prefixSum = new long[nums.length + 1];
        for(int idx = 0; idx < nums.length; idx++) {
            prefixSum[idx + 1] = prefixSum[idx] + nums[idx];
        }
        
        int leftFreq = 2, rightFreq = nums.length;
        while(leftFreq <= rightFreq) {
            int midFreq = leftFreq + ((rightFreq - leftFreq) >> 1);
            
            if(isPossible(midFreq, nums, k, prefixSum)) {
                leftFreq = midFreq + 1;
            } else {
                rightFreq = midFreq - 1;
            }
        }
        
        return rightFreq;
        
    }
}