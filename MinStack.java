class MinStack {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> min = new LinkedList<Integer>();
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || x <= min.peek()) min.push(x);
    }
    public void pop() {
        if(stack.isEmpty()) return;
        int popnum = stack.pop();
        if(!min.isEmpty() && popnum == min.peek()) min.pop();
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        return stack.peek();
    }

    public int getMin() {
        if(min.isEmpty()) return 0;
        return min.peek();
    }
}
