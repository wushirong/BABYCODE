//合理的分类思考很重要，首先分出p 长度为1以及第二位不为*的情况，然后对第二位为*的情况进行处理，
//*也可以代表前一字符串长度为0  
//while loop中后一条件的括号一定要加，否则与或判断会错导致index out of bound exception  

    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;
        
        if(p.length() == 1 || p.charAt(1) != '*') {
            if(s.length() == 0 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) return false;
            else return isMatch(s.substring(1), p.substring(1));
        }
        
        while(s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if(isMatch(s, p.substring(2))) return true;
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
}