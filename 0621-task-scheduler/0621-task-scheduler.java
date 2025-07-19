class Solution {
    class Task implements Comparable<Task>{
        int exec;
        int count;
        Task(int exex, int count){
            this.exec = exec;
            this.count = count;
        }
        public int compareTo(Task that){
            return that.count - this.count;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(new Task(0, entry.getValue()));
        }
        Queue<Task> queue = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Task t = pq.poll();
                t.count--;
                if(t.count>0){
                    t.exec = n + time;
                    queue.offer(t);
                }
            }
            if(!queue.isEmpty() && queue.peek().exec==time){
                pq.offer(queue.poll());
            }
        }
        return time;
    }
}