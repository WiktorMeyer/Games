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
     * Deals a card and removes it from the deck
     * @return 1 card
     */
    public Card dealCard(){
        return cards.remove(0);
    }

    /**
     * Shuffles cards in deck
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
