public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        int sum = 0;
        char operation = '+';
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = num * 10 + Integer.parseInt(Character.toString(cur));
            }
            if((!Character.isDigit(cur)&& cur != ' ') || i == s.length() - 1 ) {
                if(operation == '+') stack.push(num);
                if(operation == '-') stack.push(-num);
                if(operation == '*') stack.push(stack.pop() * num);
                if(operation == '/') stack.push(stack.pop() / num);
                operation = cur;
                num = 0;
            }
        }
        for(int i: stack) sum += i;
        return sum;
    }