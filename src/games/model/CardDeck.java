package games.model;

import java.util.ArrayList;
import java.util.Collections;

import static games.model.Card.*;


public class CardDeck {
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * Adds standard amount of cards to the deck
     * Can be called multiple times!
     */
    public void populateDeck(){
        for (String suit : SUIT_ARRAY) {
            for (String rank : RANK_ARRAY) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    /**
     * Shuffles cards in deck
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
