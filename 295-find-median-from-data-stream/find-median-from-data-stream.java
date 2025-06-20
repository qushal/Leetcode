class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || left.peek() > num){
            left.offer(num);
        }
        else{
            right.offer(num);
        }
        if(right.size() > left.size()){
            left.offer(right.poll());
        }
        if(left.size() == right.size() + 2){
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()){
            return left.peek();
        }
        else{
            return (left.peek() + right.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */