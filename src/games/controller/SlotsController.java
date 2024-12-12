package games.controller;

import games.model.Casino;
import games.model.Slots;
import games.view.TUI.SlotsView;

import java.util.concurrent.TimeUnit;

public class SlotsController {
    private final Slots model;
    private final SlotsView view;
    public Casino casino;

    public SlotsController(Casino casino) {
        this.casino = casino;
        this.view = new SlotsView();
        this.model = new Slots();
    }

    public void playSlots() throws InterruptedException {
        boolean play = true;

        view.displayWelcomeMessage();
        while (play) {
            int bet;
            int winnings;
            if (casino.getBalance() > 0){
                //entering bet
                view.displayMessage("Current Balance: " + casino.getBalance() +"$");
                view.displayMessage("Enter bet amount: ");
                bet = view.inputBet(casino.getBalance());
                casino.setBalance(casino.getBalance() - bet);
                //spinning slots
                view.displayMessage("Spinning...");
                TimeUnit.SECONDS.sleep(1);
                String[] row = model.spinRow();
                view.displayRow(row);
                //getting the winnings
                TimeUnit.MILLISECONDS.sleep(500);
                winnings= model.determineWinnings(row,bet);
                view.displayMessage("You won "+ winnings+"$");
                casino.setBalance(casino.getBalance() + winnings);
                //play again?
                view.displayPlayAgainQuestion();
                play = view.getBoolean();
            }else{
                view.displayNoMoney();
                play = false;
            }
        }
        view.displayTy4Playing();
    }
}
