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
                class Solution {

    public int findContentChildren(int[] greed, int[] size) {
           int count = 0;
           Arrays.sort(greed);
           Arrays.sort(size);
           int m = greed.length;
           int n = size.length;

           // greedy technique: To satisfy children with smallest possible cookie

            if(m==0 || n==0) return 0;
           // if least greedy children can't be satisfied with even largest cookie
           // No one can't be satisfied

           if(greed[0]>size[n-1])
                return 0;
            
            int childPtr = 0;
            int cookiePtr = 0;
            
            while(cookiePtr<n && childPtr<m)
            {
                if(size[cookiePtr]<greed[childPtr])
                {
                    // if current cookie can't satisfy current children
                    // it can satisfy none - other children are even more greedy
                    cookiePtr++;
                }
                else{
                    // cookie size is enough to satisfy the current children
                    cookiePtr++;
                    childPtr++;
                    count++;
                }
            }
            return count;
    }
}// Cookie too small, try a less greedy child
                greed.poll();
            }
        }

        return contentChildren;
    }
}

