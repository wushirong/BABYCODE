public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] rect = new int[m][n];
        for(int i = 0; i < m; i++) {
            rect[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            rect[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                rect[i][j] = rect[i - 1][j] + rect[i][j - 1];
            }
        }
        return rect[m-1][n-1];
    }
}