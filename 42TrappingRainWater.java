public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int res = 0;
        while (index < height.length) {
            int h = height[index];
            if (stack.isEmpty() || h <= height[stack.peek()] ) stack.push(index++);
            else {
                int top = stack.pop();
                res += stack.isEmpty()? 0: (Math.min(height[index], height[stack.peek()])-height[top])*(index-1-stack.peek());
            }
        }
        return res;
    }