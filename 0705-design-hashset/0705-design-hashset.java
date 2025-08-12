class MyHashSet {
    private final int MAX_SIZE = 1000000;
    private final int ARRAY_SIZE = 100;
    List<List<Integer>> parentlist;
    
    public MyHashSet() {
        parentlist = new ArrayList<>(ARRAY_SIZE);
        for(int i = 0; i < ARRAY_SIZE; i++){
            parentlist.add(null);
        }
    }
    
    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childlist = parentlist.get(index);
        
        if(childlist==null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentlist.set(index, list);
        } else {
            if(childlist.contains(key))return;
            else parentlist.get(index).add(key);
        }
    }
    
    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childlist = parentlist.get(index);
        if(childlist!=null){
            if(childlist.contains(key)){
                childlist.remove(Integer.valueOf(key));
            }
        }
    }
    
    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childlist = parentlist.get(index);
        
        return childlist!=null && childlist.contains(key);
    }
}
