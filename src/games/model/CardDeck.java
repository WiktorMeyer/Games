package games.model;

import java.util.ArrayList;
import java.util.Collections;

import static games.model.Card.*;


public class CardDeck {
    private ArrayList<Card> cards;

    public CardDeck() {
        cards = new ArrayList<>();
    }

    public void addCards(){
        for (String suit : SUIT_ARRAY) {
            for (String rank : RANK_ARRAY) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        deck.shuffleDeck();
        System.out.println(deck.cards);
    }
}
