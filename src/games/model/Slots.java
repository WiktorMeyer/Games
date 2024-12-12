package games.model;

import java.util.*;

public class Slots {

    /**
     * @return A String array of length 3 with random symbols
     */
    public String[] spinRow(){
        String[] row = new String[3];
        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[rand.nextInt(symbols.length)];
        }
        return row;
    }

    /**
     * A method to determine the amount won
     * @param row Already spun row of symbols
     * @param bet Amount bet by the player
     * @return Amount of $ won by the player
     */
    public int determineWinnings(String[] row, int bet){
        if (row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch (row[1]) {
                case ("🍒") -> bet * 3;
                case ("🍉") -> bet * 4;
                case ("🍋") -> bet * 5;
                case ("🔔") -> bet * 10;
                case ("⭐") -> bet * 20;
                default -> 0;
            };
        }
        if (row[0].equals(row[1]) || row[1].equals(row[2])){
            return switch (row[1]) {
                case ("🍒") -> bet * 2;
                case ("🍉") -> bet * 3;
                case ("🍋") -> bet * 4;
                case ("🔔") -> bet * 5;
                case ("⭐") -> bet * 10;
                default -> 0;
            };
        }
        return 0;
    }

}
