import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> greed = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> size = new PriorityQueue<>(Collections.reverseOrder());

        for (int child : g) {
            greed.add(child);
        }

        for (int cookie : s) {
            size.add(cookie);
        }

        int contentChildren = 0;

        while (!greed.isEmpty() && !size.isEmpty()) {
            if (size.peek() >= greed.peek()) {
                // Cookie can satisfy the child
                size.poll();
                greed.poll();
                contentChildren++;
            } else {
                // Cookie too small, try a less greedy child
                greed.poll();
            }
        }

        return contentChildren;
    }
}

