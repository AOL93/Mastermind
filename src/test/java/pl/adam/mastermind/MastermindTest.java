package pl.adam.mastermind;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MastermindTest {
    @Test
    public void drawWinColors() {
        Mastermind game = new Mastermind();

        assertEquals(0, game.getWinCombination().size());

        game.drawWinColors();

        assertEquals(4, game.getWinCombination().size());
    }


    @Test
    public void compare() {
        Mastermind game = new Mastermind();

        ArrayList<String> winCombination = new ArrayList<>();
        winCombination.add("RED");
        winCombination.add("BLUE");
        winCombination.add("YELLOW");
        winCombination.add("BLUE");

        ArrayList<String> Combination1 = new ArrayList<>();
        Combination1.add("RED");
        Combination1.add("BLUE");
        Combination1.add("YELLOW");
        Combination1.add("ORANGE");

        ArrayList<String> badCombination = new ArrayList<>();
        badCombination.add("BLACK");
        badCombination.add("BLUE");
        badCombination.add("BLACK");
        badCombination.add("BLACK");

        game.setWinCombination(winCombination);

        assertTrue(game.compare(Combination1).equals("WHITE: 0\nBLACK: 3"));
        assertTrue(game.compare(badCombination).equals("WHITE: 0\nBLACK: 1"));
        assertTrue(game.compare(winCombination).equals("WHITE: 0\nBLACK: 4"));

    }
}