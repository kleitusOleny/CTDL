package Lab5;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private char[][] board;
    
    public TicTacToe(char[][] board) {
        this.board = board;
    }
    
    public boolean checkRow() {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][0] == board[i][j] && board[i][j] != EMPTY) {
                    count++;
                }
            }
            if (count == board.length - 1) return true;
        }
        return false;
    }
    
    public boolean checkColum() {
        for (int i = 0; i < board[0].length; i++) {
            int count = 0;
            for (int j = 1; j < board.length; j++) {
                if (board[0][i] == board[j][i] && board[j][i] != EMPTY) {
                    count++;
                }
            }
            if (count == board[0].length - 1) return true;
        }
        return false;
    }
    
    public boolean checkDiagonals() {
        int count = 0;
        for (int i = 1; i < board.length; i++) {
            if (board[0][0] == board[i][i]) {
                count++;
            }
            if (count == board.length -1) return true;
        }
        count = 0;
        for (int i = 0; i < board.length; i++) {
            if(board[board.length - 1][0] == board[board.length - 1 -i][i] && board[board.length - 1 -i][i] != EMPTY){
                count++;
            }
            if (count == board.length) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        char[][] ch = {{' ', '0', 'X'},
                        {'O', 'X', 'O'},
                        {'X', 'O', 'X'}};
        TicTacToe t = new TicTacToe(ch);
        System.out.println("Col: " + t.checkColum());
        System.out.println("Row: " + t.checkRow());
        System.out.println("Diagonals: " + t.checkDiagonals());
    }
}
