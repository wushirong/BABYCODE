public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] record = new int[row+1][col+1];
        int res = 0;
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(matrix[i-1][j-1] == '1' ) {
                    record[i][j] = Math.min(Math.min(record[i][j-1], record[i-1][j] ), record[i-1][j-1] )+1;
                    res = Math.max(res, record[i][j]);
                }
            }
        }
        return res*res;
    }