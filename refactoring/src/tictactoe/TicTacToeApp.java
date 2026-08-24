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

}
