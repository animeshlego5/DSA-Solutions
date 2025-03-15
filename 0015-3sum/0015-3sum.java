class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    // Found a valid triplet
                    list.add(List.of(nums[i], nums[l], nums[r]));
                    
                    // Skip duplicates for l
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    
                    // Skip duplicates for r
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    
                    // Move both pointers
                    l++;
                    r--;
                }
            }
        }
        
        return list;
    }
}
