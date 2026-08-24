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
        new TicTacToeGui().start(new TicTacToeApp());
    }

    private final Gui gui = Gui.create("Tic Tac Toe", BOARD_SIZE, BOARD_SIZE);
    private TicTacToe game;

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
