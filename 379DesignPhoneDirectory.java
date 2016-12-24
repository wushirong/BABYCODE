public class PhoneDirectory {
    HashSet<Integer> set;
    int capacity;
    Random random;
    int count;
    Queue<Integer> queue;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.set = new HashSet<Integer>();
        this.capacity = maxNumbers;
        this.random = new Random();
        this.queue = new LinkedList<Integer>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (capacity <= count) return -1;
        count++;
        //Collections.shuffle(queue);
        set.add(queue.peek());
        return queue.poll();
        
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.remove(number)) {
            queue.offer(number);
            count--;
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */