//inplace 方法，用九宫格进行计算，对边缘用Math.mim || Math.max进行处理

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null) return;
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int live = 0;
                for(int k = Math.max(i-1, 0); k < Math.min(i+2, row); k++) {
                    for(int l = Math.max(j-1, 0); l < Math.min(j+2, col); l++) {
                        if(board[k][l] == 1 || board[k][l] == 2 ) live++;
                    }
                }
                live -= board[i][j];
                if(live == 3 && board[i][j] == 0 ) board[i][j] = 3;
                //bracket for(live < 2 || live > 3) is important but easy to omit
                if((live < 2 || live > 3) && board[i][j] == 1) board[i][j] = 2;
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j ++) {
                board[i][j] %= 2;
            }
        }
    }
    
}