import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Step 1: Sort to help skip duplicates
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path)); // Make a copy
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Step 2: Skip duplicates at the same recursive depth
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // No point continuing

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path); // Move forward: i + 1 (each element used once)
            path.remove(path.size() - 1); // Backtrack
        }
    }
}
