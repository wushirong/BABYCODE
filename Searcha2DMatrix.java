public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        for(int i = 0; i < matrix.length - 1; i++) {
            if(target >= matrix[i][0] && target < matrix[i + 1][0] ) return helper(matrix, i, target);
        }
        if(target <= matrix[matrix.length - 1][matrix[0].length - 1] ) return helper(matrix, matrix.length - 1, target);
        return false;
    }
    
    private boolean helper(int[][]matrix, int row, int target) {
        for(int i = 0; i < matrix[row].length; i++) {
            if(matrix[row][i] == target) return true;
        }
        return false;
    }
}