public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return -1;
        int sign = 1;
        int num = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
            }
            else if(c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '+'? 1:-1;
            }
            else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if(c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
            else continue;
        }
        if(num != 0) res += num * sign;
        return res;
    }
}