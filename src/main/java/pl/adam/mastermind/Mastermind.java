package pl.adam.mastermind;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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

    //TODO Use singleton to init game.
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

        //TODO Save user's combination and compare with winning combination.
    }

    /**
     * Ask user for 4 colors. Temporary String value.
     * @return ArrayList with colors.
     */
    public ArrayList askUser() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> userGuess = new ArrayList<>();

        IntStream.range(0,4)
                .forEach( i -> userGuess.add(scanner.nextLine()) );

        return userGuess;
    }

    /**
     * Compare winning combination with user's guess combination.
     * @param userGuess - Combination of user's colors.
     * @return Boolean value (for tests). True - user win or False - wrong combination
     */
    //FIXME for tests method return boolean
    public boolean compare(ArrayList userGuess) {

        int guessPosition = 0;
        int guessColor = 0;

        //Have to compare userGuess and winCombination
        //if all are correct game end and user win, if not looking for other colors

        for(int i=0;i<winCombination.size();i++) {

            if(userGuess.contains(winCombination.get(i))) {
                if(winCombination.get(i).equals(userGuess.get(i))) {
                    guessPosition++;
                } else{
                    guessColor++;
                }
            }
        }

        //white - right color, wrong position
        //black - right color, right position
        System.out.println("WHITE: " + guessColor);
        System.out.println("BLACK: " + guessPosition);

        return guessPosition == 4;
    }

    /**
     * Method to get an array with winning colors.
     * @return Array with winning colors
     */
    public ArrayList<String> getWinCombination() {
        return winCombination;
    }
}
