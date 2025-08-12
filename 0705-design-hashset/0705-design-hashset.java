class MyHashSet {
    private boolean[] set;
    
    public MyHashSet() {
        set = new boolean[1000001]; // key range 0..1,000,000
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}
