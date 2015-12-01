public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        for(int i = 0; i < matrix.length; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                if(helper(matrix, i, target)) return true;
            } 
        }
        
        return false;
    }
    
    private boolean helper(int[][] matrix, int row, int target) {
        for(int i = 0; i < matrix[row].length; i++) {
            if(matrix[row][i] == target) return true;
        }
        return false;
    }
}