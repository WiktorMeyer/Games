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

    public void displayPlayerCards(ArrayList<Card> cards) {
        System.out.println("Your cards are:");
        System.out.println(cards);
    }

    public void displayCardsValue(int[] value) {
        System.out.print("Total value: ");
        if (value[0] == value[1]) {
            System.out.print(value[0]);
        }else{
            System.out.println(value[0] + " or " + value[1]);
        }
    }
}
