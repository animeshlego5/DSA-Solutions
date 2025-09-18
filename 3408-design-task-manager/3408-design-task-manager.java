class TaskManager {
    private class Entry{
        int userId;
        int taskId;
        int priority;
        Entry(int userId,int taskId,int priority){
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
    private class Task{
        int priority;
        int userId;
        Task(int userId, int priority){
            this.priority = priority;
            this.userId = userId;
        }
    }
    private Map<Integer, Task> map;
    private PriorityQueue<Entry> pq;
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->a.priority!=b.priority?b.priority-a.priority : b.taskId - a.taskId);
        for(List<Integer> task : tasks){
            add(task.get(0), task.get(1), task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new Task(userId, priority));
        pq.add(new Entry(userId, taskId, priority));
    }
    
    public void edit(int taskId, int newPriority) {
        Task t = map.get(taskId);
        map.put(taskId, new Task(t.userId, newPriority));
        pq.add(new Entry(t.userId, taskId, newPriority));
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            Entry e = pq.peek();
            Task t = map.get(e.taskId);
            if(t == null || e.priority != t.priority || e.userId != t.userId){
                pq.poll();
                continue;
            }
            pq.poll();
            map.remove(e.taskId);
            return e.userId;
        }
        return -1;
        
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */