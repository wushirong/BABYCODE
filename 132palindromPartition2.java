public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cur = new int[len];
        boolean[][] palin = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && ((j+1>i-1) || palin[j+1][i-1])) {
                    palin[j][i] = true;
                    min = j == 0? 0: Math.min(min, cur[j-1]+1); 
                }
                cur[i] = min;
            }
        }
        return cur[len-1];
    }