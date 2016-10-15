public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')  return 0;
        int len = s.length();
        int[] matrix = new int[len+1];
        matrix[len] = 1;
        matrix[len-1] = s.charAt(len-1) - '0' == 0? 0:1;
        for (int i = len-2; i >= 0; i--) {
            int cur = s.charAt(i) - '0';
            if (cur == 0) continue;
            else {
                matrix[i] = matrix[i+1] + (Integer.parseInt(s.substring(i, i+2)) < 27? matrix[i+2]:0);
            }
        }
        return matrix[0];
    }