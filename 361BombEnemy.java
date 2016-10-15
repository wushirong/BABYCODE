public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        int row = 0;
        int[] col = new int[y];
        int max = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(grid[i][j] == 'W' ) continue;
                if(j == 0 || grid[i][j-1] == 'W') row = setRow(grid, i, j);
                if(i == 0 || grid[i-1][j] == 'W') col[j] = setCol(grid, i, j);
                if(grid[i][j] == '0') max = Math.max(max, row + col[j]);
            }
        }
        return max;
    }
    
    private int setRow(char[][] grid, int i, int j) {
        int count = 0;
        int plus = j;
        while(plus < grid[0].length && grid[i][plus] != 'W') {
            if(grid[i][plus] == 'E' ) count++;
            plus++;
        }
        return count;
    }
    
    private int setCol(char[][] grid, int i, int j) {
        int count = 0;
        int plus = i;
        while(plus < grid.length && grid[plus][j] != 'W') {
            if(grid[plus][j] == 'E' ) count++;
            plus++;
        }
        return count;
    }