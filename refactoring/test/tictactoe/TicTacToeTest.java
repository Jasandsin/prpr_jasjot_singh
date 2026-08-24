package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {

    @Test
    void newGameStartsWithPlayerX() {
        TicTacToe game = new TicTacToe();
        assertEquals(Player.X, game.getCurrentPlayer());
    }

    @Test
    void boardEmpty() {
        TicTacToe game = new TicTacToe();
        assertEquals(null, game.getField(0, 0));
    }

    @Test
    void spielStartetMitX() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        assertEquals(Player.X, game.getField(0, 0));
    }


    @Test
    void spielerWechselNachrunde() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        assertEquals(Player.O, game.getCurrentPlayer());
    }

    @Test
    void NoStartWhenOutOfBoard() {
        TicTacToe game = new TicTacToe();

        assertThrows(IllegalArgumentException.class, () -> {
            game.play(5, 6);
        });
    }

    @Test
    void noStartWhenGameIsOver() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        game.play(1, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(0, 2);
        assertThrows(IllegalStateException.class, () -> {
            game.play(2, 2);
        });
    }

    @Test
    void xGewinntEineReihe() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        game.play(1, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(0, 2);
        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void xGewinntZweiteReihe() {
        TicTacToe game = new TicTacToe();

        game.play(1, 0);
        game.play(0, 0); 
        game.play(1, 1); 
        game.play(0, 1); 
        game.play(1, 2); 

        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void xGewinntDritteReihe() {
        TicTacToe game = new TicTacToe();

        game.play(2, 0); 
        game.play(0, 0); 
        game.play(2, 1); 
        game.play(0, 1); 
        game.play(2, 2); 

        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void xGewinntErsteSpalte() {
        TicTacToe game = new TicTacToe();

        game.play(0, 0); 
        game.play(0, 1); 
        game.play(1, 0); 
        game.play(1, 1); 
        game.play(2, 0); 

        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void xGewinntZweiteSpalte() {
        TicTacToe game = new TicTacToe();

        game.play(0, 1); 
        game.play(0, 0); 
        game.play(1, 1); 
        game.play(1, 0); 
        game.play(2, 1); 

        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void xGewinntDritteSpalte() {
        TicTacToe game = new TicTacToe();

        game.play(0, 2); 
        game.play(0, 0); 
        game.play(1, 2); 
        game.play(1, 0); 
        game.play(2, 2); 

        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void xGewinntDiagonaleLinksNachRechts() {
        TicTacToe game = new TicTacToe();

        game.play(0, 0); 
        game.play(0, 1); 
        game.play(1, 1); 
        game.play(0, 2); 
        game.play(2, 2); 

        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void xGewinntDiagonaleRechtsNachLinks() {
        TicTacToe game = new TicTacToe();

        game.play(0, 2); 
        game.play(0, 0); 
        game.play(1, 1); 
        game.play(0, 1); 
        game.play(2, 0); 

        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void belegtesFeldWirdIgnoriert() {
        TicTacToe game = new TicTacToe();

        game.play(0, 0);
        game.play(0, 0);

        assertEquals(Player.X, game.getField(0, 0));
        assertEquals(Player.O, game.getCurrentPlayer());
    }

    @Test
    void spielIstNachGewinnBeendet() {
        TicTacToe game = new TicTacToe();

        game.play(0, 0);
        game.play(1, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(0, 2);

        assertEquals(true, game.isOver());
    }

}
