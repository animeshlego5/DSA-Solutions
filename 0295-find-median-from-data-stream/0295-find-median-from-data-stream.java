class MedianFinder {
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    int size = 0;
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        size++;
        if(num<=maxheap.size() || maxheap.isEmpty()){
            maxheap.add(num);
        } else{
            minheap.add(num);
        }
        //balance
        if(minheap.size() + 1 <maxheap.size()){
           minheap.add(maxheap.poll());
        } else if(maxheap.size()<minheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(size%2==0){
            int l = maxheap.peek();
            int r = minheap.peek();
            return (double)(l+r)/2;
        } else return (maxheap.size()>minheap.size())?(double)maxheap.peek():(double)minheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */