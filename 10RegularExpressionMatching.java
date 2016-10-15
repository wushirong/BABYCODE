//DP
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] matrix = new boolean[s.length()+1][p.length()+1];
        matrix[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*') {
                if (matrix[0][i-1] || (i > 1 && matrix[0][i-2]) )
                matrix[0][i] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char cs = s.charAt(i-1);
                char cp = p.charAt(j-1);
                if (cs == cp || cp == '.') matrix[i][j] = matrix[i-1][j-1];
                if (cp == '*') {
                    if ( (p.charAt(j-2) != cs && p.charAt(j-2) != '.')) matrix[i][j] = matrix[i][j-2];
                    else matrix[i][j] = matrix[i][j-1] || matrix[i][j-2] || matrix[i-1][j];
                }
            }
        }
        return matrix[s.length()][p.length()];
    }


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