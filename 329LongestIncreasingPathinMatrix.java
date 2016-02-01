public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] record = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                dfs(matrix, record, i, j);
                max = Math.max(max, record[i][j]);
            }
        }
        return max;
    }
    private void dfs(int[][] matrix, int[][] record, int row, int col) {
        if(record[row][col] != 0) return;
        int res = 0;
        if(row - 1 >= 0 && matrix[row-1][col] > matrix[row][col]) {
            dfs(matrix, record, row-1, col);
            res = Math.max(res, record[row-1][col]);
        }
        if(col - 1 >= 0 && matrix[row][col-1] > matrix[row][col]) {
            dfs(matrix, record, row, col-1);
            res = Math.max(res, record[row][col-1]);
        }
        if(row + 1 < matrix.length && matrix[row+1][col] > matrix[row][col]) {
            dfs(matrix, record, row+1, col);
            res = Math.max(res, record[row+1][col]);
        }
        if(col + 1 < matrix[0].length && matrix[row][col+1] > matrix[row][col]) {
            dfs(matrix, record, row, col+1);
            res = Math.max(res, record[row][col+1]);
        }
        
        record[row][col] = res + 1;
    }