public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger root = new NestedInteger();
        stack.push(root);
        int start = 1;
        for(int i = 1; i < s.length(); i++ ) {
            char cur = s.charAt(i);
            if(cur == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = i + 1;
            }
            else if (cur == ']' || cur == ',') {
                if(i > start) {
                    String str = s.substring(start, i);
                    NestedInteger ni = new NestedInteger(Integer.parseInt(str));
                    stack.peek().add(ni);
                }
                start = i + 1;
                if(cur == ']') stack.pop();
            }
        }
        return root;
    }