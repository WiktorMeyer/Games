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
            int winnings = 0;
            //check if player has money
            if (casino.getBalance() < 0){
                view.displayNoMoney();
                break;
            }

            //get bet
            view.displayBalance(casino.getBalance());
            int bet = view.inputBet(casino.getBalance());
            casino.setBalance(casino.getBalance() - bet);

            //deck populating and shuffling
            CardDeck deck = model.getDeck();
            deck.populateDeck();
            deck.shuffleDeck();

            //get hands of both players
            ArrayList<Card> casinoCards = model.getCasinoCards();
            ArrayList<Card> playerCards = model.getPlayersCards();

            //deal initial cards
            playerCards.add(deck.dealCard());
            playerCards.add(deck.dealCard());
            casinoCards.add(deck.dealCard());
            casinoCards.add(deck.dealCard());

            boolean playerTurn = true;
            while (playerTurn) {
                //calculate card value
                int[] playersValue = model.calculateCardsValue(playerCards);
                int[] casinosValue = model.calculateCardsValue(new ArrayList<>(List.of(casinoCards.get(0))));

                //display casino's hand
                view.displayMessage("Casino's cards are:");
                view.displayMessage(casinoCards.get(0).toString());
                view.displayCardsValue(casinosValue);

                //display player's hand
                view.displayPlayerCards(playerCards);
                view.displayCardsValue(playersValue);

                //check for busts or BlackJack
                if (playersValue[0] > 21){
                    view.displayMessage("Busted!");
                    break;
                } else if (playersValue[0] == 21 || playersValue[1] == 21){
                    view.displayMessage("Black Jack!");
                    winnings = (int) (bet * 2.5);
                    view.displayMessage("You win " + winnings + "$");
                    break;
                }

                //get player's decision
                String decision = view.determineMove();
                if (decision.equals("stand")){
                    winnings = casinosTurn(casinoCards, playerCards, deck, bet);
                    playerTurn = false;
                } else {//hit
                    playerCards.add(deck.dealCard());
                }
            }
            casino.setBalance(casino.getBalance() + winnings);
            //play again?
            view.displayPlayAgainQuestion();
            play = view.getBoolean();
        }
        view.displayTy4Playing();

    }

    public int casinosTurn(ArrayList<Card> casinoCards, ArrayList<Card> playerCards, CardDeck deck, int bet) {
        int[] casinosValue;
        int[] playersValue;
        do {
            //display casino's both cards
            casinosValue = model.calculateCardsValue(casinoCards);
            view.displayMessage("Casino's cards are:");
            view.displayMessage(casinoCards.toString());
            view.displayCardsValue(casinosValue);
            //display player's cards
            playersValue = model.calculateCardsValue(playerCards);
            view.displayPlayerCards(playerCards);
            view.displayCardsValue(playersValue);
            //casino draws cards
            if (casinosValue[0] < 17 || !(casinosValue[1] > 17 && casinosValue[1] <= 21)){
                view.displayMessage("Casino draws a card");
                casinoCards.add(deck.dealCard());
            }
        } while (casinosValue[0] < 17 && (casinosValue[1] < 17 || casinosValue[1] > 21));
        return model.getWinnings(casinosValue, playersValue, bet);
    }
}
