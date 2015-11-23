public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            int newint;
            int pre;
            int post;
            switch(cur) {
                case("+"):
                    newint = stack.pop() + stack.pop();
                    stack.add(newint);
                    break;
                case("-"):
                    pre = stack.pop();
                    post = stack.pop();
                    newint = post - pre;
                    stack.add(newint);
                    break;
                case("*"):
                    newint = stack.pop() * stack.pop();
                    stack.add(newint);
                    break;
                case("/"):
                    pre = stack.pop();
                    post = stack.pop();
                    newint = post / pre;
                    stack.add(newint);
                    break;
                default:
                    newint = Integer.parseInt(cur);
                    stack.add(newint);
                    break;
            }
            
        }
        return stack.pop();
        
    }
}