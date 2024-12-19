package games.view.TUI;

import games.model.Card;

import java.util.ArrayList;

public class BlackJackView extends View {

    @Override
    public void displayWelcomeMessage() {
        System.out.println("**********************");
        System.out.println("Welcome to Black Jack!");
        System.out.println("**********************");
    }

    public void displayPlayerCards(ArrayList<Card> cards) {
        System.out.println(cards);
    }
}
