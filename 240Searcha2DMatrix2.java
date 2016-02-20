//O(m+n) time solution
public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(col >= 0 && row < matrix.length) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else if(matrix[row][col] < target) row++;
        }
        return false;
    }
//basic solution 
public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1, y = col - 1;
        for(;x >= 0; x--) {
            if(matrix[x][0] == target) return true;
            if(matrix[x][0] < target) break;
        }
        for(; y >= 0; y--) {
            if(matrix[0][y] == target) return true;
            if(matrix[0][y] < target) break;
        }
        for(int i = 0; i <= x; i++) {
            for(int j = 0; j <= y; j++) {
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }