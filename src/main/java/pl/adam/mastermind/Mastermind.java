package pl.adam.mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Mastermind {

    //TODO Sockets to play with server

    private int rounds;
    private boolean userWin;
    private ArrayList<String> colors;
    private ArrayList<String> winCombination;

    public Mastermind() {
        rounds = 8;
        userWin = false;
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
        ArrayList<String> userGuess = new ArrayList<>();
        int attempts = 0;

        System.out.println("Welcome in Mastermind console version(by the way Graphic version as soon as possible).");
        System.out.println("After draw colors write 4 colors in console(color per line).");
        System.out.println("Available colors: BLACK, BLUE, GREEN, ORANGE, RED, WHITE, YELLOW");
        System.out.println("You've got 8 rounds to guess winning combination. GOOD LUCK AND HAVE FUN :)");
        drawWinColors();

        //TODO Save user's combination and compare with winning combination.
        do {
            userGuess = askUser();
            attempts++;
            compare(userGuess);
        }while( !userWin && attempts<=rounds );

        if(userWin) {
            System.out.println("CONGRATULATION!!!\nYOU'RE WINNER!!!");
        } else {
            System.out.println("YOU LOSE :(\nMAYBE NEXT TIME");
            System.out.println("Win combination:");
            IntStream.range(0, winCombination.size())
                    .forEach( i -> System.out.println(winCombination.get(i)) );
        }
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
     * Method looking for correct colors and positions first. If find one change
     * variable in Array checkArray to null(it's important to not remove element because array lose position
     * of next colors). After that looking for correct colors only.
     * @param userGuess - Combination of user's colors.
     * @return Boolean value (for tests). True - user win or False - wrong combination
     */
    //FIXME for tests method return boolean
    public String compare(ArrayList userGuess) {

        ArrayList<String> checkArray = (ArrayList<String>) winCombination.clone();
        String resultMsg;

        int guessPosition = 0;
        int guessColor = 0;

        //TODO use equalsIgnoreCase
        //First check correct colors and positions.
        for(int i=0;i<winCombination.size();i++) {
            if(checkArray.contains(userGuess.get(i))) {
                if(checkArray.get(i).equals(userGuess.get(i))) {

                    checkArray.set(i,null); //
                    //guessPosition++;
                }
            }
        }

        //Check correct colors but wrong position (without counting the same color twice)
        for(int i=0;i<winCombination.size();i++) {
            if(checkArray.contains(userGuess.get(i)) && checkArray.get(i) != null ) {

                checkArray.set(
                        checkArray.indexOf(userGuess.get(i)),
                        "poss");
                //guessColor++;
            }
        }

        guessColor = Collections.frequency(checkArray,"poss");
        guessPosition = Collections.frequency(checkArray,null);

        //white - right color, wrong position
        //black - right color, right position
        //System.out.println("WHITE: " + guessColor);
        //System.out.println("BLACK: " + guessPosition);

        userWin = guessPosition == 4;

        resultMsg = "WHITE: " + guessColor + "\n" + "BLACK: " + guessPosition;

        return resultMsg;
    }

    /**
     * Method to get an array with winning colors.
     * @return Array with winning colors
     */
    public ArrayList<String> getWinCombination() {
        return winCombination;
    }

    /**
     * Return true if user win else user still in game
     * or loose(the limit of rounds has been reached)
     * @return
     */
    public boolean isUserWin() {
        return userWin;
    }

    /**
     * Set winCombination - helps in tests
     * @param winCombination
     */
    public void setWinCombination(ArrayList<String> winCombination) {
        this.winCombination = winCombination;
    }
}
