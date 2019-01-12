package pl.adam.mastermind;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Unnecessary things:
 * - possible rounds to guess combination,
 * - array of possible colors,
 * - array with winning combination,
 * - ...
 *
 */


public class Mastermind {

    //TODO Interaction with the user
    //TODO Compare user guess with winCombination
    //TODO Sockets

    private int rounds;
    private ArrayList<String> colors;
    private ArrayList<String> winCombination;

    public Mastermind() {
        rounds = 8;
        colors = new ArrayList<>();
        winCombination = new ArrayList<>();

        colors.add("BLACK");
        colors.add("BLUE");
        colors.add("GREEN");
        colors.add("ORANGE");
        colors.add("RED");
        colors.add("WHITE");
        colors.add("YELLOW");
    }

    /**
     * The method draws 4 winning colors from pool of available colors.
     */
    public void drawWinColors() {
        Random random = new Random();
        IntStream.range(0,4)
                .forEach( i -> winCombination.add(colors.get(random.nextInt(colors.size()))) );

    }

    /**
     * Starting game.
     */
    public void start() {
        drawWinColors();

        IntStream.range(0, winCombination.size())
                .forEach( i -> System.out.println(winCombination.get(i)) );
    }

    /**
     * Method to get an array with winning colors.
     * @return Array with winning colors
     */
    public ArrayList<String> getWinCombination() {
        return winCombination;
    }
}
