package tictactoe;

public class TicTacToeGui {


    private void drawBoard(TicTacToeApp ticTacToeApp) {
        ticTacToeApp.gui.setColor(220, 220, 220);
        ticTacToeApp.gui.fillRect(0, 0, TicTacToeApp.BOARD_SIZE, TicTacToeApp.BOARD_SIZE);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                var x = col * TicTacToeApp.FIELD_SIZE + (col + 1) * TicTacToeApp.MARGIN;
                var y = row * TicTacToeApp.FIELD_SIZE + (row + 1) * TicTacToeApp.MARGIN;
                ticTacToeApp.gui.setColor(255, 255, 255);
                ticTacToeApp.gui.fillRect(x, y, TicTacToeApp.FIELD_SIZE, TicTacToeApp.FIELD_SIZE);

                ticTacToeApp.gui.setStrokeWidth(20);
                if (ticTacToeApp.game.getField(row, col) == Player.X) {
                    ticTacToeApp.gui.setColor(ticTacToeApp.getXColor());
                    ticTacToeApp.gui.drawLine(
                            x + TicTacToeApp.PADDING, y + TicTacToeApp.PADDING,
                            x + TicTacToeApp.FIELD_SIZE - TicTacToeApp.PADDING, y + TicTacToeApp.FIELD_SIZE - TicTacToeApp.PADDING);
                    ticTacToeApp.gui.drawLine(
                            x + TicTacToeApp.FIELD_SIZE - TicTacToeApp.PADDING, y + TicTacToeApp.PADDING,
                            x + TicTacToeApp.PADDING, y + TicTacToeApp.FIELD_SIZE - TicTacToeApp.PADDING);
                } else if (ticTacToeApp.game.getField(row, col) == Player.O) {
                    ticTacToeApp.gui.setColor(ticTacToeApp.getOColor());
                    ticTacToeApp.gui.drawOval(x + TicTacToeApp.PADDING, y + TicTacToeApp.PADDING,
                            TicTacToeApp.FIELD_SIZE - 2 * TicTacToeApp.PADDING, TicTacToeApp.FIELD_SIZE - 2 * TicTacToeApp.PADDING);
                }
            }
        }
    }

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
