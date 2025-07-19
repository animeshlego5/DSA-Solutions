class MedianFinder {
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    int size = 0;
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        size++;
        if(  maxheap.isEmpty() ||num<=maxheap.peek()){
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
            return (maxheap.peek() + minheap.peek())/2.0;
        } else return (maxheap.size()>minheap.size())?(double)maxheap.peek():(double)minheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */