import java.util.*;

class Solution {
    public int countElements(int[] nums) {
        // Convert the array to a List of Integers
        List<Integer> numList = new ArrayList<>();
        for (int n : nums) {
            numList.add(n);
        }

        // Sort the list
        Collections.sort(numList);
        
        // Initialize the count
        int count = 0;

        // Find the minimum and maximum elements
        int min = numList.get(0);
        int max = numList.get(numList.size() - 1);

        // Count elements between the min and max values
        for (int n : numList) {
            if (n > min && n < max) {
                count++;
            }
        }

        return count;
    }
}
