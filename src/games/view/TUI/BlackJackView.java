package games.view.TUI;

import games.model.Card;

import java.util.ArrayList;

public class BlackJackView extends View {

    @Override
    public void displayWelcomeMessage() {
        System.out.println("**********************");
        System.out.println("Welcome to Black Jack!");
        System.out.println("**********************\n");
    }

    /**
     * Your cards are:
     * @param cards players cards
     */
    public void displayPlayerCards(ArrayList<Card> cards) {
        System.out.println("\nYour cards are:");
        System.out.println(cards);
    }

    public void displayCasinoCards(ArrayList<Card> cards) {
        System.out.println("\nCasino's cards are:");
        System.out.println(cards);
    }

    public void displayCasinoCards(Card card) {
        System.out.println("\nCasino's card is:");
        System.out.println(card);
    }

    public void displayCardsValue(int[] value) {
        System.out.print("Total value: ");
        if (value[0] == value[1] || value[1] > 21) {
            System.out.println(value[0]);
        }else{
            System.out.println(value[0] + " or " + value[1]);
        }
    }

    /**
     * @return "hit" or "stand"
     */
    public String determineMove(){
        System.out.println("HIT or STAND?");
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("hit")){
                    return "hit";
                } else if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("stand")){
                    return "stand";
                } else {
                    System.out.println("Enter h for hit or s for stand");
                }
            } catch (Exception e) {
                System.out.println("Enter h for hit or s for stand");
            }
        }
    }
    public void waitingForEnter(){
        scanner.nextLine();
    }
}
