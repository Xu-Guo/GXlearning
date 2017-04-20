public class MedianFinder {
    Queue<Integer> small;
    Queue<Integer> large;
    double median;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((x1, x2) -> x2-x1);
        large = new PriorityQueue<>();
        median = 0;
    }
    
    public void addNum(int num) {
        if(num < median){
            small.add(num);
        }else{
            large.add(num);
        }
        if(large.size() > small.size()){
            small.add(large.poll());
        }
        if(small.size() - large.size() > 1){
            large.add(small.poll());
        }
    }
    
    public double findMedian() {
        if(small.size() == 0 && large.size() == 0){
            return 0;
        }
        if(small.size() == large.size()){
             median = ((double)small.peek() + (double)large.peek()) / 2.0;
        }else{
             median = (double)small.peek();
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */