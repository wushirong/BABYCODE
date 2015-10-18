class MyStack {
    // Push element x onto stack.
    private LinkedList<Integer> q1 = new LinkedList<Integer>();
    private LinkedList<Integer> q2 = new LinkedList<Integer>();
    
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(q1.isEmpty()) return;
        transfer();
        while(q2.size() > 1){
            q1.offer(q2.poll());
        }
        q2.poll();
    }

    // Get the top element.
    public int top() {
        if(q1.isEmpty()) return 0;
        transfer();
        while(q2.size() > 1) {
            q1.offer(q2.poll());
        }
        int res = q2.peek();
        q1.offer(q2.poll());
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
    
    public void transfer() {
        LinkedList<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
}