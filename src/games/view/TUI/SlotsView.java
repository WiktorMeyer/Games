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

    /**
     * Displays a row of symbols
     * @param row an Array that we want to display
     */
    public void displayRow(String[] row) {
        System.out.println(Arrays.toString(row));
    }
}
