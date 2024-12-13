package games.view.TUI;

import java.util.Optional;

import static java.lang.Integer.parseInt;

public class GuessNumberView extends View {

    @Override
    public void displayWelcomeMessage() {
        System.out.println("************************");
        System.out.println("Welcome to Guess Number!");
        System.out.println("************************\n");
    }

    public void displayGuessBetween(int min, int max) {
        System.out.printf("Guess the number between %d and %d:%n", min, max);
    }

    /**
     * reads the number
     *
     * @return an integer that is in range
     */
    public int inputNumberInRange(int min, int max) {
        Optional<Integer> enteredNumber = Optional.empty();
        while (enteredNumber.isEmpty()) {
            try {
                int input = parseInt(scanner.nextLine());
                if (input < min || input > max){
                    System.out.println("That is outside the range.");
                    displayGuessBetween(min, max);
                } else {
                    enteredNumber = Optional.of(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return enteredNumber.get();
    }
}