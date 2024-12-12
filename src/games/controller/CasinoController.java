package games.controller;

import games.model.Casino;
import games.view.TUI.CasinoView;

public class CasinoController {
    private CasinoView view;
    private Casino model;

    public CasinoController() {
        this.view = new CasinoView();
        this.model = new Casino();
    }

    /**
     * A whole sequence of commands that simulate playing at the casino
     */
    public void playCasino(){
        int choice;
        view.displayMessage("Welcome to Casino!");
        view.displayMessage("What is your balance?");
        model.setBalance(model.inputBalance());
        do {
            view.displayOptions();
            choice = model.getNumber();
            if (choice == 1){
                //TODO: play Blackjack
            } else if (choice == 2){
                GuessNumberController guessNumberController = new GuessNumberController();
                guessNumberController.playGuessNumber();
            } else if (choice == 3){
                SlotsController slotsController = new SlotsController();
                slotsController.playSlots();
            } else {
                view.displayMessage("Invalid choice!");
            }
            view.displayMessage("Do you want to exit casino? (Y/N)");
        } while (!model.getBoolean());
        view.displayMessage("Thank you for playing!");
    }
}
