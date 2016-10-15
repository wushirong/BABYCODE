public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int operator = 1;
        int result = 0;
        int len = s.length();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur) ) {
                num = cur - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                result += operator * num;
            }
            if ((!Character.isDigit(cur) && cur != ' ') || i == s.length() - 1 ) {
                if(cur == '+') {
                    operator = 1;
                }
                if(cur == '-') {
                    operator = -1;
                }
                if(cur == '(') {
                    stack.push(result);
                    stack.push(operator);
                    result = 0;
                    operator = 1;
                }
                if(cur == ')') {
                    result = result * stack.pop() + stack.pop();
                }
            }
        }
        return result;
    }