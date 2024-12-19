package games.controller;

import games.model.BlackJack;
import games.model.Card;
import games.model.CardDeck;
import games.model.Casino;
import games.view.TUI.BlackJackView;

import java.util.ArrayList;
import java.util.List;

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
            int winnings =0;
            int bet;
            CardDeck deck = model.getDeck();
            ArrayList<Card> playerCards = model.getPlayersCards();
            ArrayList<Card> casinoCards = model.getCasinoCards();
            if (casino.getBalance() > 0){
                //get bet
                view.displayBalance(casino.getBalance());
                bet = view.inputBet(casino.getBalance());
                casino.setBalance(casino.getBalance() - bet);
                deck.populateDeck();
                deck.shuffleDeck();
                //deal cards
                playerCards.add(deck.dealCard());
                playerCards.add(deck.dealCard());
                casinoCards.add(deck.dealCard());
                casinoCards.add(deck.dealCard());
                boolean hit = true;
                while (hit) {
                    //calculate card value
                    int[] playersValue = model.calculateCardsValue(playerCards);
                    int[] casinosValue = model.calculateCardsValue(new ArrayList<>(List.of(casinoCards.get(0))));
                    //show casino's hand
                    view.displayMessage("Casino's cards are:");
                    view.displayMessage(casinoCards.get(0).toString());
                    view.displayCardsValue(casinosValue);
                    //determine the move
                    String move = view.determineMove();
                    //show player's hand
                    view.displayPlayerCards(playerCards);
                    view.displayCardsValue(playersValue);
                    //check if players deck is over 21
                    if (playersValue[0] > 21){
                        view.displayMessage("Busted!");
                        winnings = 0;
                        break;
                    }else if (playersValue[0] == 21 || playersValue[1] == 21){
                        view.displayMessage("Black Jack!");
                        winnings = (int) (bet * 2.5);
                        view.displayMessage("You win "+winnings+"$");
                        break;
                    }
                    //ask player for his decision
                    String decision = view.determineMove();
                    if (decision.equals("stand")) {
                        do {
                            //display casino cards
                            casinosValue = model.calculateCardsValue(casinoCards);
                            view.displayMessage("Casino's cards are:");
                            view.displayMessage(casinoCards.toString());
                            view.displayCardsValue(casinosValue);
                            //display player's cards
                            view.displayPlayerCards(playerCards);
                            view.displayCardsValue(playersValue);
                            //casino draws cards
                            if (casinosValue[0] < 17 || !(casinosValue[1] > 17 && casinosValue[1] <= 21)){
                                view.displayMessage("Casino draws a card");
                                casinoCards.add(deck.dealCard());
                            }
                        }while (casinosValue[0] < 17 || !(casinosValue[1] > 17 && casinosValue[1] <= 21));
                        winnings = getWinnings(casinosValue,playersValue,bet);
                        hit = false;
                    }else{
                        playerCards.add(deck.dealCard());
                    }
                }
                casino.setBalance(casino.getBalance() + winnings);
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
    public int getWinnings(int[] casinosValue, int[] playersValue, int bet) {
        int playerBestValue;
        int casinoBestValue;
        int winnings;
        if (playersValue[0] <= 21){
            playerBestValue = playersValue[0];
        }else{
            playerBestValue = playersValue[1];
        }
        if (casinosValue[0] <= 21){
            casinoBestValue = casinosValue[0];
        }else{
            casinoBestValue = casinosValue[1];
        }
        if (playerBestValue > casinoBestValue) {
            winnings = bet * 2;
        } else if (playerBestValue < casinoBestValue) {
            winnings = 0;
        } else {
            winnings = bet;
        }
        return winnings;
    }
}
