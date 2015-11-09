public class Solution {
    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};
    private int isLand;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int sum = 0;
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!mark[i][j] && grid[i][j] == '1') {
                    helper(grid, mark, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }
    private void helper(char[][] grid, boolean[][] mark, int row, int col) {
        mark[row][col] = true;
        for(int[] neibor: neibor(grid.length, grid[0].length, row, col)) {
            int neiborX = neibor[0], neiborY = neibor[1];
            if(!mark[neiborX][neiborY] && grid[neiborX][neiborY] == '1') {
                helper(grid, mark, neiborX, neiborY);
            }
        }
    }
    private List<int[]> neibor(int m, int n, int row, int col) {
        List<int[]> res = new ArrayList<int[]>();
        for(int k = 0; k < 4; k++) {
            int x = dirX[k] + row, y = dirY[k] + col;
            if(x >= 0 && x < m && y >= 0 && y < n) {
                res.add(new int[]{x, y});
            }
        }
        return res;
    }
}