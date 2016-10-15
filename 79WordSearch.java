public class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] record = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(DFS(board, record, word, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean DFS(char[][]board, boolean[][] record, String word, int x, int y) {
        if(word.length() == 0) return true;
        if(record[x][y] || word.charAt(0) != board[x][y]) return false;
        else if(word.length() == 1) return true;
        
        for(int i = 0; i < 4; i++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if(newx >=0 && newy >=0 && newx < board.length && newy <board[0].length) {
                record[x][y] = true;
                if(DFS(board, record, word.substring(1), newx, newy)) return true;
                record[x][y] = false;
            }
        }
        
        return false;
    }
}