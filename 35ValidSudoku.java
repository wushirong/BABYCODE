public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> inclie = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]) ) return false;
                if (board[j][i] != '.' && !col.add(board[j][i]) ) return false;
                int irow = 3*(i/3) + j/3;
                int icol = 3*(i%3) + j%3;
                if (board[irow][icol] != '.' && !inclie.add(board[irow][icol])) return false;
            }
        }
        return true;
    }