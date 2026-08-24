package tictactoe;

public class TicTacToeGui {


    void start(TicTacToeApp ticTacToeApp) {
        ticTacToeApp.game = new TicTacToe();

        ticTacToeApp.drawBoard();
        ticTacToeApp.gui.open();

        while (ticTacToeApp.gui.isOpen()) {
            if (ticTacToeApp.gui.wasLeftMouseButtonClicked()) {
                int row = (int) (ticTacToeApp.gui.getMouseY() - TicTacToeApp.MARGIN / 2) / (TicTacToeApp.FIELD_SIZE + TicTacToeApp.MARGIN);
                int col = (int) (ticTacToeApp.gui.getMouseX() - TicTacToeApp.MARGIN / 2) / (TicTacToeApp.FIELD_SIZE + TicTacToeApp.MARGIN);
                ticTacToeApp.game.play(row, col);
            }

            if (ticTacToeApp.game.isOver()) {
                do {
                    ticTacToeApp.drawBoard();
                    ticTacToeApp.gui.refreshAndClear(20);
                } while (ticTacToeApp.gui.isOpen() && !ticTacToeApp.gui.wasLeftMouseButtonClicked());

                // start new game
                ticTacToeApp.game = new TicTacToe();
            }

            ticTacToeApp.drawBoard();
            ticTacToeApp.gui.refreshAndClear(20);
        }
    }
}
