    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int len = matrix.length;
        int wid = matrix[0].length;
        int[] height = new int[wid];
        int[] left = new int[wid];
        int[] right = new int[wid];
        Arrays.fill(right, wid);
        int max = 0;
        for (int i = 0; i < len; i++) {
            int curLeft = 0;
            int curRight = wid-1;
            for (int j = 0; j < wid; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < wid; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(curLeft, left[j]);
                else {
                    curLeft = j+1;
                    left[j] = 0;
                }
            }
            for (int j = wid-1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(curRight, right[j]);
                else {
                    curRight = j-1;
                    right[j] = wid-1;
                }
            }
            for (int j = 0; j < wid; j++) {
                max = Math.max(max, (right[j] - left[j]+1)*height[j] );
            }
        }
        return max;
    }


public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] record = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') record[i][j] = height(matrix, i, j);
            }
        }
        int res = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(record[i][j] > 0) res = Math.max(counter(record, i, j), res);
            }
        }
        return res;
    }
    
    private int height(char[][] matrix, int row, int col) {
        int res = 1;
        while(++row < matrix.length && (matrix[row][col] == '1')) {
            res++;
        }
        return res;
    }
    
    private int counter(int[][] record, int row, int col) {
        int height = record[row][col++];
        int width = 1;
        int res = width * height;
        while(col < record[0].length && record[row][col] > 0) {
            height = Math.min(height, record[row][col++]);
            width++;
            res = Math.max(height * width, res);
        }
        return res;
    }
}