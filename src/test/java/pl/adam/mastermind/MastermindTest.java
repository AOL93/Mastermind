package pl.adam.mastermind;

import org.junit.Test;

import static org.junit.Assert.*;

public class MastermindTest {
    @Test
    public void drawWinColors() {
        Mastermind game = new Mastermind();

        assertEquals(0, game.getWinCombination().size());

        game.drawWinColors();

        assertEquals(4, game.getWinCombination().size());
    }
}