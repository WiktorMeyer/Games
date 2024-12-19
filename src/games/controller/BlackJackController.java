package games.controller;

import games.model.BlackJack;
import games.model.Casino;
import games.view.TUI.BlackJackView;

public class BlackJackController {

    private final BlackJack model;
    private final BlackJackView view;
    private final Casino casino;

    public BlackJackController(Casino casino) {
        this.view = new BlackJackView();
        this.model = new BlackJack();
        this.casino = casino;
    }

    public void playBlackJack() {
        boolean play = true;
        view.displayWelcomeMessage();
        while (play) {
            int bet;
            int winnings;
            if (casino.getBalance() > 0){
                //get bet
                view.displayBalance(casino.getBalance());
                bet = view.inputBet(casino.getBalance());
                casino.setBalance(casino.getBalance() - bet);
                //TODO: play BlackJack
                //play again?
                view.displayPlayAgainQuestion();
                play = view.getBoolean();
            }else{
                view.displayNoMoney();
                play = false;
            }
            view.displayTy4Playing();
        }
    }
}
