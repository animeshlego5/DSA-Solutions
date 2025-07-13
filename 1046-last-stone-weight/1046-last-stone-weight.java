class Solution {
    PriorityQueue<Integer> pq;
    public int lastStoneWeight(int[] stones) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
           int i =  pq.poll();
           int j = pq.poll();
           int diff = i - j;
           if(diff==0)continue;
           pq.offer(diff);
        }
        return pq.isEmpty()?0:pq.poll();
    }
}