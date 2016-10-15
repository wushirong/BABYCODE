public int[][] generateMatrix(int n) {
        if (n  < 1) return new int[n][n];
        int[][] matrix = new int[n][n];
        int index = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while(true) {
            for (int i = left; i <= right; i++ ) matrix[top][i] = index++;
            top++;
            if (top > bottom || left > right) break;
            
            for (int i = top; i <= bottom; i++ ) matrix[i][right] = index++;
            right--;
            if (top > bottom || left > right) break;
            
            for (int i = right; i >= left; i-- ) matrix[bottom][i] = index++;
            bottom--;
            if (top > bottom || left > right) break;
            
            for (int i = bottom; i >= top; i-- ) matrix[i][left] = index++;
            left++;
            if (top > bottom || left > right) break;
        }
        return matrix;
    }