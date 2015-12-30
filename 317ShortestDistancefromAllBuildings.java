public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        final int[] shift = new int[]{0, 1, 0, -1, 0};
        int[][] total = new int[row][col];
        int[][] dis = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingnum = 0;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    buildingnum++;
                    boolean[][] visited = new boolean[row][col];
                    Queue<int[]> building  = new LinkedList<int[]>();
                    building.offer(new int[]{i, j});
                    while(!building.isEmpty()) {
                        int[] cur = building.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int d = 0; d < 4; d++) {
                            int nearx = shift[d] + x;
                            int neary = y + shift[d+1];
                            if(nearx >= 0 && nearx < row && neary >= 0 && neary < col 
                               && !visited[nearx][neary] && grid[nearx][neary] == 0) {
                                   dis[nearx][neary] = dis[x][y] + 1;
                                   visited[nearx][neary] = true;
                                   total[nearx][neary] += dis[nearx][neary];
                                   building.offer(new int[]{nearx, neary});
                                   reach[nearx][neary]++;
                               }
                        }
                    }
                }
                
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 0 && reach[i][j] == buildingnum ) res = Math.min(total[i][j], res);
            }
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}