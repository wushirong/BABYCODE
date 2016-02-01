public boolean isNumber(String s) {
        if(s == null ) return false;
        s = s.trim();
        if(s.length() == 0) return false;
        boolean dot = false;
        boolean exp = false;
        boolean num = false;
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1: 0;
        while(i < s.length()) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) num = true;
            else if(cur == 'e') {
                if(exp || !num) return false;
                else {
                    exp = true;
                    num = false;
                }
            }
            else if(cur == '.') {
                if(dot || exp) return false;
                else dot = true;
            }
            else if(cur == '+' || cur == '-') {
                if(s.charAt(i -  1) != 'e') return false;
            }
            else return false;
            i++;
        }
        return num;
    }