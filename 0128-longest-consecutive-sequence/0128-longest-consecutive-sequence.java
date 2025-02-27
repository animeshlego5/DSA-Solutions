import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Store the elements in a set for O(1) lookup time
        Set<Integer> storage = new HashSet<>();
        for (int n : nums) {
            storage.add(n);
        }

        int longestSequence = 0;

        // Iterate through each number in the set
        for (int num : storage) {
            // Check if the current number is the start of a sequence
            if (!storage.contains(num - 1)) {  // This means `num` is the start of a sequence
                int currentNum = num;
                int currentStreak = 1;

                // Count how many consecutive numbers follow
                while (storage.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest sequence found
                longestSequence = Math.max(longestSequence, currentStreak);
            }
        }

        return longestSequence;
    }
}
