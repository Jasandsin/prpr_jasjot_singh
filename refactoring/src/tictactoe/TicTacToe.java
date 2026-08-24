package tictactoe;

public class TicTacToe {

    int getWinner(TicTacToeApp ticTacToeApp) {
        for (int i = 0; i < 3; i++) {
            if (ticTacToeApp.board[i][0] != 0 &&
                ticTacToeApp.board[i][0] == ticTacToeApp.board[i][1] &&
                ticTacToeApp.board[i][0] == ticTacToeApp.board[i][2]) {
                return ticTacToeApp.board[i][0];
            }
            if (ticTacToeApp.board[0][i] != 0 &&
                ticTacToeApp.board[0][i] == ticTacToeApp.board[1][i] &&
                ticTacToeApp.board[0][i] == ticTacToeApp.board[2][i]) {
                return ticTacToeApp.board[0][i];
            }
        }
        if (ticTacToeApp.board[0][0] != 0 &&
            ticTacToeApp.board[0][0] == ticTacToeApp.board[1][1] &&
            ticTacToeApp.board[0][0] == ticTacToeApp.board[2][2]) {
            return ticTacToeApp.board[0][0];
        }
        if (ticTacToeApp.board[0][2] != 0 &&
            ticTacToeApp.board[0][2] == ticTacToeApp.board[1][1] &&
            ticTacToeApp.board[0][2] == ticTacToeApp.board[2][0]) {
            return ticTacToeApp.board[0][2];
        }
        return 0;
    }
}
