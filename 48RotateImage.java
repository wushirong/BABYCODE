public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row-1-j];
                matrix[i][row-1-j] = temp;
            }
        }
    }


//using extra space

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int len = matrix.length;
        int[][] temp = new int[len][matrix[0].length];
        for(int i = 0; i < len; i++)
            for(int j = 0; j < matrix[i].length; j++)
                temp[i][j] = matrix[i][j];
        for(int i = 0; i < len; i++) {
            for(int j =0; j < len; j++) {
                matrix[j][len - 1 -i] = temp[i][j];
            }
        }
    }
    
}