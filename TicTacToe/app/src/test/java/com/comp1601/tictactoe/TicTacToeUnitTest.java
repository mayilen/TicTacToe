package com.comp1601.tictactoe;

import org.junit.Test;

import java.util.Random;

public class TicTacToeUnitTest {
    @Test
    public void gameTest()throws Exception {
        TicTacToeGame game = new TicTacToeGame();
        Random rand = new Random();
        while (!game.drawGame() && game.winner() == null) {//if theres no draw or a winner keep playing
            int position = rand.nextInt(9);
            while (!game.checkPosition(position)) {///loop until theres a valid position
                position = rand.nextInt(9);

            }
            game.play(game.getPlayerRole(),position);//call play function to play at the position
        }
    }
}
