public class NumMatrix {
    int[][] numMatrix;
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return;
        this.numMatrix = matrix;
        sum = new int[numMatrix.length + 1][numMatrix[0].length + 1];
        for(int i = 1; i <= numMatrix.length; i++) {
            for(int j = 1; j <= numMatrix[0].length; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + numMatrix[i-1][j-1] - sum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 < 0 || row1 >= numMatrix.length || row2 < 0 || row2 >= numMatrix.length || 
        col1 < 0 || col1 >= numMatrix[0].length || col2 < 0 || col2 >= numMatrix[0].length) 
        return 0;
        
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}
