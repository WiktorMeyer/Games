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

    public void playGuessNumber() {
        boolean play = true;
        int bet;
        int winnings;

        view.displayWelcomeMessage();
        while (play) {
            int multiplier = 10;
            //enter the bet
            view.displayMessage("Current Balance: " + casino.getBalance() + "$");
            bet = view.inputBet(casino.getBalance());
            casino.setBalance(casino.getBalance() - bet);
            //generate a random number
            int randomNumber = model.generateRandomNumber(model.getMIN(), model.getMAX());
            view.displayGuessBetween(model.getMIN(), model.getMAX());
            //try to guess the number until success
            int enteredNumber;
            do {
                enteredNumber = view.inputNumberInRange(model.getMIN(), model.getMAX());
                if (enteredNumber != randomNumber){
                    view.displayMessage("Incorrect :c Try again!");
                    multiplier = switch (multiplier) {
                        case 10 -> 5;
                        case 5 -> 2;
                        default -> 0;
                    };
                }
            } while (enteredNumber != randomNumber);
            view.displayMessage("Correct! The number was: " + randomNumber);

            winnings = bet * multiplier;
            view.displayMessage("You won " + winnings + "$");
            casino.setBalance(casino.getBalance() + winnings);

            if (casino.getBalance() > 0){
                //play again?
                view.displayPlayAgainQuestion();
                play = view.getBoolean();
            } else {
                view.displayNoMoney();
                play = false;
            }
        }
    }

}
