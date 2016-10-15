public class MovingAverage {
    Queue<Integer> queue = new LinkedList<Integer>();
    int width;
    long sum;
    int cur;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        width = size;
        sum = 0;
    }
    
    public double next(int val) {
        if(queue.size() == width) sum -= queue.remove();
        sum += val;
        queue.add(val);
        return (double)sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */