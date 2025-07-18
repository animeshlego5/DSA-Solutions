class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            if(pq.size()<k || pq.peek()<num){
                if(pq.size()>=k)pq.poll();
                pq.offer(num);
            }
        
        }
        return pq.poll();
    }
}