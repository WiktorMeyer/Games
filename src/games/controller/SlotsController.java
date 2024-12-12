package games.controller;

import games.model.Casino;
import games.model.Slots;
import games.view.TUI.SlotsView;

import java.util.concurrent.TimeUnit;

public class SlotsController {
    private Slots model;
    private SlotsView view;
    public Casino casino;

    public SlotsController(Casino casino) {
        this.casino = casino;
        this.view = new SlotsView();
        this.model = new Slots();
    }

    public void playSlots() throws InterruptedException {
        boolean play = true;

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
                view.displayMessage("Do you want to play again? (Y/N)");
                play = view.getBoolean();
            }else{
                view.displayNoMoney();
                play = false;
            }
        }
        view.displayTy4Playing();
    }
}
