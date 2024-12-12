package games.controller;

import games.model.Slots;
import games.view.TUI.SlotsView;

import java.util.concurrent.TimeUnit;

public class SlotsController {
    private Slots model;
    private SlotsView view;

    public void playSlots() throws InterruptedException {
        boolean play = true;

        while (play) {
            int bet;
            int winnings;
            if (getCasino().getBalance() > 0){
                System.out.println("Current Balance: " + getCasino().getBalance() +"$");
                System.out.println("Enter bet amount: ");
                bet = inputBet();
                getCasino().setBalance(getCasino().getBalance() - bet);
                System.out.println("Spinning...");
                TimeUnit.SECONDS.sleep(1);
                winnings= determineWinnings(spinRow(),bet);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("You won "+ winnings+"$");
                getCasino().setBalance(getCasino().getBalance() + winnings);
                System.out.println("Do you want to play again? (Y/N)");
                play = getCasino().getBoolean();
            }else{
                System.out.println("You have no money in your wallet. :(");
                play = false;
            }
        }
        System.out.println("Thank you for playing!");
    }
}
