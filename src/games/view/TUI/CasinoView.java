package games.view.TUI;

public class CasinoView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayOptions(){
        System.out.println("What do you want to play?");
        System.out.println("Press 1 for Blackjack");
        System.out.println("Press 2 for Guess Number");
        System.out.println("Press 3 for Slots");
    }
}