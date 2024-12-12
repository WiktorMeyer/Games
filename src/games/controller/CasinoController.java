package games.controller;

import games.model.Casino;
import games.view.TUI.CasinoView;

public class CasinoController {
    private final CasinoView view;
    private final Casino model;

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
        model.setBalance(view.inputBalance());
        do {
            view.displayOptions();
            choice = view.inputNumber();
            if (choice == 1){
                //TODO: play Blackjack
            } else if (choice == 2){
                GuessNumberController guessNumberController = new GuessNumberController(model);
                guessNumberController.playGuessNumber();
            } else if (choice == 3){
                SlotsController slotsController = new SlotsController(model);
                try {
                    slotsController.playSlots();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                view.displayMessage("Invalid choice!");
            }
            view.displayMessage("Do you want to exit casino? (Y/N)");
        } while (!view.getBoolean());
        view.displayTy4Playing();
    }
}
