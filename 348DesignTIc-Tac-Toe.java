public class TicTacToe {
    List<ArrayList<Integer>> record1 = new ArrayList<ArrayList<Integer>>();
    List<ArrayList<Integer>> record2 = new ArrayList<ArrayList<Integer>>();
    int size;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        for(int i = 0; i < n + n + 2; i++) {
            record1.add(new ArrayList<Integer>());
            record2.add(new ArrayList<Integer>());
        } 
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1) {
            if(record1.get(row).size() == size - 1) return 1;
            else record1.get(row).add(1);
            if(record1.get(size + col).size() == size - 1) return 1;
            else record1.get(size + col).add(1);
            if(row == col) {
                if(record1.get(2 * size).size() == size - 1) return 1;
                else record1.get(2 * size).add(1);
            }
            if(row == size - col - 1) {
                if(record1.get(2 * size + 1).size() == size - 1) return 1;
                else record1.get(2 * size + 1).add(1);
            }
        }
        else {
            if(record2.get(row).size() == size - 1) return 2;
            else record2.get(row).add(1);
            if(record2.get(size + col).size() == size - 1) return 2;
            else record2.get(size + col).add(1);
            if(row == col) {
                if(record2.get(2 * size).size() == size - 1) return 2;
                else record2.get(2 * size).add(1);
            }
            if(row == size - col - 1) {
                if(record2.get(2 * size + 1).size() == size - 1) return 2;
                else record2.get(2 * size + 1).add(1);
            }
        }
        return 0;
    }

}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */