package games.model;

public class Card {
    private final String rank;
    private final String suit;

    // ---- constants -----------------------------------

    // ranks are 2, ..., 9 and:
    public static final String JACK = "Jack";
    public static final String QUEEN = "Queen";
    public static final String KING = "King";
    public static final String ACE = "Ace";
    public static final String TEN = "Ten";

    // suits are:
    public static final String CLUBS = "Clubs";
    public static final String DIAMONDS = "Diamonds";
    public static final String HEARTS = "Hearts";
    public static final String SPADES = "Spades";

    // some convenient arrays
    public static final String[] RANK_ARRAY = {"2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public static final String[] SUIT_ARRAY = {"Clubs", "Diamonds",
            "Hearts", "Spades"};


    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    /**
     *
     * @return String representation of Card object in format: rank + " of " + suit
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
