public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] mark = new boolean[board.length][board[i].length];
                    if(helper(0, i, j, word, board, mark)) return true;
                }
            }
        }
        return false;
    }
    private boolean helper(int index, int row, int col, String word, char[][] board, boolean[][] mark) {
        if(index == word.length()) return true;
        if(row < 0 || col < 0 || row > board.length - 1  || col > board[0].length - 1 || 
           mark[row][col] || board[row][col] != word.charAt(index)) return false;
        index++;
        mark[row][col] = true;
        boolean res = helper(index, row - 1, col, word, board, mark) ||
                      helper(index, row + 1, col, word, board, mark) ||
                      helper(index, row, col + 1, word, board, mark) ||
                      helper(index, row, col - 1, word, board, mark);
        mark[row][col] = false;
        return res;
    }
}