class Solution {
    public int removeDuplicates(int[] nums) {
        int current = nums[0];
        int count = 1;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                if (count < 2) {
                    nums[k] = nums[i];
                    k++;
                    count++;

                }
                continue;
            } else {
                current = nums[i];
                nums[k] = nums[i];
                k++;
                count = 1;
            }

        }
        return k;
    }
}