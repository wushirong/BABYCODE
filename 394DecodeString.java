class Couple {
        int repeat;
        String s;
        Couple next;
        public Couple(int val) {
            this.s = null;
            this.repeat = val;
            this.next = null;
        }
        public void add(Couple cp) {
            this.next = cp;
        }
    }
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        Stack<Couple> stack = new Stack<>();
       Couple root = new Couple(1);
       stack.push(root);
       int num = 0;
        for (int i = 0; i < s.length(); i++ ) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch) ) {
                num  = num * 10 + Integer.parseInt(Character.toString(ch));
            }
            else if (ch == '[') {
            	Couple cur = new Couple(num); 
            	num = 0;
            	stack.peek().add(cur);
                if (sb.length() > 0) {
                    stack.peek().s = sb.toString();
                    sb.setLength(0);
                }
                stack.push(cur);
            }
            else if (ch == ']' ) {
                Couple pop = stack.pop();
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < pop.repeat; j++) {
                    str.append(sb.toString());
                }
                sb = new StringBuilder();
                if (stack.peek().s != null) sb.append(stack.peek().s);
                sb.append(str.toString());
                System.out.println(sb);
                stack.peek().s = sb.toString();
            }
            else sb.append(ch);
        }
        System.out.println(sb);
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < root.repeat; j++) {
            str.append(sb.toString());
        }
        return str.toString();
    }