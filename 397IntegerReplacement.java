public int integerReplacement(int n) {
        if (n <= 1) return 0;
        return dfs((long)n);
    }
    
    private int dfs(long n) {
        if (n <= 1) return 0;
        if ( n % 2 == 0) return 1 + dfs(n / 2);
        else return Math.min(dfs(n + 1), dfs(n - 1)) + 1;
    }