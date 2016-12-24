class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if (output.isEmpty()) {
            while(!input.isEmpty()) output.push(input.pop());
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

//using stack to copy the behavior of queue

class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    public void push(int x) {
        s1.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(s1.isEmpty()) return;
        while(s1.size() > 1) {
            s2.add(s1.pop());
        }
        s1.pop();
        while(! s2.isEmpty()) {
            s1.add(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        if(s1.isEmpty()) return 0;
        while(s1.size() > 1) {
            s2.add(s1.pop());
        }
        int res = s1.peek();
        while(! s2.isEmpty()) {
            s1.add(s2.pop());
        }
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}

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