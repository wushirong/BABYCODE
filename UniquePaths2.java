public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int i = 0; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] != 1) res[i][0] = 1;
            else break;
        }
        for(int i = 0; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] != 1) res[0][i] = 1;
            else break;
        }
        for(int i = 1; i < obstacleGrid.length; i++) {
            for(int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1) continue;
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}