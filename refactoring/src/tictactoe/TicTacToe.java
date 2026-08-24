package tictactoe;

import jakarta.annotation.Nonnull;

public class TicTacToe {

    private Player[][] board;
    private int moves;


    public TicTacToe() {
        board = new Player[3][3];
        moves = 0;
    }

    Player getField(int row, int col) {
        return board[row][col];
    }

    void play(int row, int col) {
        if (board[row][col] == null) {
            board[row][col] = getCurrentPlayer();
            moves++;
        }
    }

    @Nonnull
    private Player getCurrentPlayer() {
        return moves % 2 == 0 ? Player.X : Player.O;
    }

    Player getWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null &&
                board[i][0] == board[i][1] &&
                board[i][0] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != null &&
                board[0][i] == board[1][i] &&
                board[0][i] == board[2][i]) {
                return board[0][i];
            }
        }
        if (board[0][0] != null &&
            board[0][0] == board[1][1] &&
            board[0][0] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != null &&
            board[0][2] == board[1][1] &&
            board[0][2] == board[2][0]) {
            return board[0][2];
        }
        return null;
    }

    boolean isOver() {
        return getWinner() != null || moves == 9;
    }

}
