public int getMoneyAmount(int n) {
        if (n <= 1) return 0;
        int[][] table = new int[n+1][n+1];
        return helper(table, 1, n);
    }
    
    private int helper(int[][] table, int i, int j) {
        if (i >= j) return 0;
        if (table[i][j] > 0) return table[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cur = k + Math.max(helper(table, i, k-1), helper(table, k+1, j));
            res = Math.min(cur, res);
        }
        table[i][j] = res;
        return res;
    }