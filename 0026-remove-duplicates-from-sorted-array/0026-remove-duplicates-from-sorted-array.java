class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0; // Handle empty array
        }
        
        int holder = 1; // Pointer for the next unique position

        // Start checking from the second element
        for (int i = 1; i < nums.length; i++) {
            // If current element is not equal to the last unique element
            if (nums[i] != nums[holder - 1]) {
                nums[holder] = nums[i]; // Place it at the next unique position
                holder++; // Move the pointer forward
            }
        }

        return holder; // 'holder' is the count of unique elements
    }
}
