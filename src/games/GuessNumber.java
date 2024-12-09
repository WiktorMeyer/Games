package games;

import java.util.Optional;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * A simple guess number game
 * You input the number to the console until you
 * guess the number that was generated randomly
 * By default the number are in [1,10] range
 */
//TODO: implement playing for money
//TODO: implement playing in a loop

public class GuessNumber {

    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Casino casino;

    public GuessNumber(Casino casino) {
        this.casino = casino;
    }

    public void playGuessNumber(){
        int randomNumber = generateRandomNumber(MIN, MAX);
        System.out.println("Guess the number between 1 and 10:");
        int enteredNumber = readNumber();
        while (enteredNumber != randomNumber) {
            System.out.println("Incorrect :c Try again!");
            enteredNumber = readNumber();
        }
        System.out.println("Correct! The number was: " + randomNumber);
    }

    /**
     * reads the number
     * @return an integer that is in range
     */
    private int readNumber() {
        Optional<Integer> enteredNumber = Optional.empty();
        while (enteredNumber.isEmpty()) {
            try {
                int input = parseInt(SCANNER.nextLine());
                if (input < MIN || input > MAX) {
                    System.out.println("That is outside the range.");
                    System.out.printf("Please enter a number between %d and %d.%n", MIN, MAX);
                }else{
                    enteredNumber = Optional.of(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return enteredNumber.get();
    }

    /**
     *
     * @param min lower bound of the interval
     * @param max upper bound of the interval
     * @return an integer between min and max inclusive
     */
    private int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
