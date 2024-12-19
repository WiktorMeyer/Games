package games.controller;

import games.model.BlackJack;
import games.model.Card;
import games.model.CardDeck;
import games.model.Casino;
import games.view.TUI.BlackJackView;

import java.util.ArrayList;
import java.util.Arrays;

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
            CardDeck deck = model.getDeck();
            ArrayList<Card> playerCards = model.getPlayersCards();
            ArrayList<Card> casinoCards = model.getCasinoCards();
            if (casino.getBalance() > 0){
                //get bet
                view.displayBalance(casino.getBalance());
                bet = view.inputBet(casino.getBalance());
                casino.setBalance(casino.getBalance() - bet);
                //TODO: play BlackJack
                deck.populateDeck();
                deck.shuffleDeck();
                //deal cards
                playerCards.add(deck.dealCard());
                playerCards.add(deck.dealCard());
                casinoCards.add(deck.dealCard());
                casinoCards.add(deck.dealCard());
                //show to the player his cards and 1st casino card
                view.displayPlayerCards(playerCards);
                int[] value = model.calculateCardsValue(playerCards);
                view.displayCardsValue(value);
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
