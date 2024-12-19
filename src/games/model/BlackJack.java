package games.model;

import java.util.ArrayList;

public class BlackJack {
    private ArrayList<Card> casinoCards = new ArrayList<Card>();
    private ArrayList<Card> playersCards = new ArrayList<Card>();
    private CardDeck deck = new CardDeck();

    public ArrayList<Card> getCasinoCards() {
        return casinoCards;
    }

    public ArrayList<Card> getPlayersCards() {
        return playersCards;
    }

    public CardDeck getDeck() {
        return deck;
    }
}
