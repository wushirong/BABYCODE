public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null||board.length == 0){
            return true;
        }
        
        HashSet<Character> checking = new HashSet<Character>();
        for(int i = 0; i < board.length; i++) {
            checking = new HashSet<Character>();
            for(int j = 0;j < board[i].length; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if(! checking.add(board[i][j])){
                    return false;
                }
            }
        }
        for(int i = 0; i< board[0].length; i++) {
            checking = new HashSet<Character>();
            for(int j = 0;j < board.length; j++) {
                if(board[j][i] == '.') continue;
                if(! checking.add(board[j][i])){
                    return false;
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                checking = new HashSet<Character>();
                for(int k = 3*i; k < 3+3*i; k++) {
                    for(int l = 3*j; l < 3+3*j; l++){
                        if(board[k][l] == '.') continue;
                        if(!checking.add(board[k][l])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}