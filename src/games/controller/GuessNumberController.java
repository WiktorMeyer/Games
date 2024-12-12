package games.controller;

import games.model.Casino;
import games.model.GuessNumber;
import games.view.TUI.GuessNumberView;

public class GuessNumberController {
    private final GuessNumber model;
    private final GuessNumberView view;
    private final Casino casino;

    public GuessNumberController(Casino casino) {
        this.casino = casino;
        view = new GuessNumberView();
        model = new GuessNumber();
    }

    public void playGuessNumber(){
        boolean play = true;

        view.displayWelcomeMessage();
        while(play) {
            //generate a random number
            int randomNumber = model.generateRandomNumber(model.getMIN(), model.getMAX());
            view.displayGuessBetween(model.getMIN(), model.getMAX());
            //try to guess the number until success
            int enteredNumber;
            do {
                enteredNumber = view.inputNumberInRange(model.getMIN(), model.getMAX());
                if (enteredNumber != randomNumber){
                    view.displayMessage("Incorrect :c Try again!");
                }
            } while (enteredNumber != randomNumber);
            //TODO: get winnings
            view.displayMessage("Correct! The number was: " + randomNumber);
            //play again?
            view.displayPlayAgainQuestion();
            play = view.getBoolean();
        }
    }

}
