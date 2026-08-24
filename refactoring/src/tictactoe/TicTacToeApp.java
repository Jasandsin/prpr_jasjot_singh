package tictactoe;

import ch.trick17.gui.Color;
import ch.trick17.gui.Gui;


public class TicTacToeApp {

    private static final int FIELD_SIZE = 150;
    private static final int MARGIN = 10;
    private static final int PADDING = 20;
    private static final int BOARD_SIZE = 3 * FIELD_SIZE + 4 * MARGIN;
    private static final Color GAME_OVER_COLOR = new Color(200, 200, 200);

    public static void main(String[] args) {
        new TicTacToeApp().start();
    }

    private final Gui gui = Gui.create("Tic Tac Toe", BOARD_SIZE, BOARD_SIZE);
    private TicTacToe game;

    private void start() {
        game = new TicTacToe();

        drawBoard();
        gui.open();

        while (gui.isOpen()) {
            if (gui.wasLeftMouseButtonClicked()) {
                int row = (int) (gui.getMouseY() - MARGIN / 2) / (FIELD_SIZE + MARGIN);
                int col = (int) (gui.getMouseX() - MARGIN / 2) / (FIELD_SIZE + MARGIN);
                game.play(row, col);
            }

            if (game.isOver()) {
                do {
                    drawBoard();
                    gui.refreshAndClear(20);
                } while (gui.isOpen() && !gui.wasLeftMouseButtonClicked());

                // start new game
                game = new TicTacToe();
            }

            drawBoard();
            gui.refreshAndClear(20);
        }
    }

    private void drawBoard() {
        gui.setColor(220, 220, 220);
        gui.fillRect(0, 0, BOARD_SIZE, BOARD_SIZE);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                var x = col * FIELD_SIZE + (col + 1) * MARGIN;
                var y = row * FIELD_SIZE + (row + 1) * MARGIN;
                gui.setColor(255, 255, 255);
                gui.fillRect(x, y, FIELD_SIZE, FIELD_SIZE);

                gui.setStrokeWidth(20);
                if (game.getField(row, col) == Player.X) {
                    gui.setColor(getXColor());
                    gui.drawLine(
                            x + PADDING, y + PADDING,
                            x + FIELD_SIZE - PADDING, y + FIELD_SIZE - PADDING);
                    gui.drawLine(
                            x + FIELD_SIZE - PADDING, y + PADDING,
                            x + PADDING, y + FIELD_SIZE - PADDING);
                } else if (game.getField(row, col) == Player.O) {
                    gui.setColor(getOColor());
                    gui.drawOval(x + PADDING, y + PADDING,
                            FIELD_SIZE - 2 * PADDING, FIELD_SIZE - 2 * PADDING);
                }
            }
        }
    }

    private Color getXColor() {
        if (game.isOver() && game.getWinner() != Player.X) {
            return GAME_OVER_COLOR;
        } else {
            return new Color(200, 50, 50);
        }
    }

    private Color getOColor() {
        if (game.isOver() && game.getWinner() != Player.O) {
            return GAME_OVER_COLOR;
        } else {
            return new Color(40, 40, 220);
        }
    }
}
