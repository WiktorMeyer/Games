package games.view.TUI;

import java.util.Arrays;

public class SlotsView extends View {

    @Override
    public void displayWelcomeMessage() {
        System.out.println("************************");
        System.out.println("Welcome to Java Slots!");
        System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐");
        System.out.println("************************\n");
    }

    public void displayRow(String[] row){
        System.out.println(Arrays.toString(row));
    }
}
