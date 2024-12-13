package games.view.TUI;

public class CasinoView extends View {

    public void displayOptions() {
        System.out.println("What do you want to play?");
        System.out.println("Press 1 for Blackjack");
        System.out.println("Press 2 for Guess Number");
        System.out.println("Press 3 for Slots");
    }

    @Override
    public void displayWelcomeMessage() {
        System.out.println("***************************");
        System.out.println("Welcome to the Java Casino");
        System.out.println("***************************");
    }
}
