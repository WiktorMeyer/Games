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

    /**
     * Calculates value for cards in BlackJack
     * @param cards of which value needs to be calculated
     * @return value of the card provided
     */
    public int[] calculateCardsValue(ArrayList<Card> cards) {
        int[] value = {0,0};
        for (Card card : cards) {
            String rank = card.getRank();
            try {
                value[0] += Integer.parseInt(rank);
                value[1] += Integer.parseInt(rank);
            }catch (NumberFormatException e) {
                if (rank.equals("Ten") || rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                    value[0] += 10;
                    value[1] += 10;
                }else if (rank.equals("Ace")) {
                    value[0] += 1;
                    value[1] += 11;
                }else{
                    System.out.println("Error occured");
                }
            }
        }
        return value;
    }

    public int getWinnings(int[] casinosValue, int[] playersValue, int bet) {
        int playerBestValue = getBestValue(playersValue);
        int casinoBestValue = getBestValue(casinosValue);

        if (playerBestValue > casinoBestValue){
            return bet * 2;
        } else if (playerBestValue < casinoBestValue){
            return 0;
        } else {
            return bet;
        }
    }

    private int getBestValue(int[] values) {
        return (values[1] <= 21) ? values[1] : values[0];
    }
}
