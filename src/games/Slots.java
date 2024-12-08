package games;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Slots {
    private static Scanner scanner = new Scanner(System.in);
    private Casino casino;

    public Slots(Casino casino) {
        this.casino = casino;
    }

    public void playSlots() throws InterruptedException {
        boolean play = true;

        System.out.println("************************");
        System.out.println("Welcome to Java Slots!");
        System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐");
        System.out.println("************************\n");

        while (play) {
            int bet;
            int winnings;
            if (casino.getBalance() > 0){
                System.out.println("Current Balance: " + casino.getBalance() +"$");
                System.out.println("Enter bet amount: ");
                bet = inputBet();
                casino.setBalance(casino.getBalance() - bet);
                System.out.println("Spinning...");
                TimeUnit.SECONDS.sleep(1);
                winnings= determineWinnings(spinRow(),bet);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("You won "+ winnings+"$");
                casino.setBalance(casino.getBalance() + winnings);
                System.out.println("Do you want to play again? (Y/N)");
                play = casino.playAgain();
            }else{
                System.out.println("You have no money in your wallet. :(");
                play = false;
            }
        }
        System.out.println("Thank you for playing!");
    }

    /**
     * @return A String array of length 3 with random symbols
     */
    public static String[] spinRow(){
        String[] row = new String[3];
        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[rand.nextInt(symbols.length)];
        }
        System.out.println(Arrays.toString(row));
        return row;
    }

    /**
     * A methods to get the bet amount from the user
     * @return amount that the user wants to bet
     */
    public int inputBet(){
        Optional<Integer> bet = Optional.empty();

        while (bet.isEmpty()) {
            try{
                bet = Optional.of(Integer.parseInt(scanner.nextLine()));
                if (bet.get() > casino.getBalance()){
                    System.out.println("You don't have enough money!");
                    bet = Optional.empty();
                }else if(bet.get() <= 0){
                    System.out.println("Bet must be greater than 0");
                    bet = Optional.empty();
                    System.out.println("Enter bet amount: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer");
                System.out.println("Enter bet amount: ");
            }
        }
        return bet.get();
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
