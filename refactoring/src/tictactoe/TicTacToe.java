package tictactoe;

public class TicTacToe {

    private int[][] board;
    private int moves;


    public TicTacToe() {
        board =  new int[3][3];
        moves = 0;
    }

    void play(int row, int col) {
        if (board[row][col] == 0) {
            board[row][col] = moves % 2 + 1;
            moves++;
        }
    }

    int getWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 &&
                board[i][0] == board[i][1] &&
                board[i][0] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != 0 &&
                board[0][i] == board[1][i] &&
                board[0][i] == board[2][i]) {
                return board[0][i];
            }
        }
        if (board[0][0] != 0 &&
            board[0][0] == board[1][1] &&
            board[0][0] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != 0 &&
            board[0][2] == board[1][1] &&
            board[0][2] == board[2][0]) {
            return board[0][2];
        }
        return 0;
    }
}
