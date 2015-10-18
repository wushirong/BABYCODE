class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(s1.isEmpty()) return;
        while(s1.size() > 1) {
            s2.push(s1.pop());
        }
        s1.pop();
        while(s2.size() > 0) {
            s1.push(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        if(s1.isEmpty()) return 0;
        while(s1.size() > 1) {
            s2.push(s1.pop());
        }
        int res = s1.peek();
        s2.push(s1.pop());
        while(s2.size() > 0) {
            s1.push(s2.pop());
        }
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }

}