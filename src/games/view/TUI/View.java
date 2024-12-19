package games.view.TUI;

import java.util.Optional;
import java.util.Scanner;

public abstract class View {

    protected final Scanner scanner = new Scanner(System.in);

    /**
     * prints "Thank you for playing!"
     */
    public void displayTy4Playing() {
        System.out.println("Thank you for playing!");
    }

    /**
     * Displays welcome message. Different for each game
     */
    public abstract void displayWelcomeMessage();


    /**
     * prints the message to console
     * @param message you want to print
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Ask the user to input how much they want to bet
     * @ensures bet is <= to the balance
     * @param balance current balance of the player
     * @return amount that user wants to bet
     */
    public int inputBet(int balance) {
        Optional<Integer> bet = Optional.empty();

        displayMessage("Enter bet amount: ");
        while (bet.isEmpty()) {
            try {
                bet = Optional.of(Integer.parseInt(scanner.nextLine()));
                if (bet.get() > balance){
                    System.out.println("You don't have enough money!");
                    bet = Optional.empty();
                    System.out.println("Enter bet amount: ");
                } else if (bet.get() <= 0){
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
     * Gets a boolean based on user input (either yes or no)
     * @return true if yes, false if no
     */
    public boolean getBoolean() {
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
                    return true;
                } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
                    return false;
                } else {
                    System.out.println("Enter y or n");
                }
            } catch (Exception e) {
                System.out.println("Enter y or n");
            }
        }
    }

    public void displayNoMoney() {
        System.out.println("You have no money in your wallet. :(");
    }

    public void displayPlayAgainQuestion() {
        System.out.println("Do you want to play again? (Y/N)");
    }

    /**
     * A method to get a number from a user
     *
     * @return number input by the user
     */
    public int inputNumber() {
        Optional<Integer> number = Optional.empty();
        while (number.isEmpty()) {
            try {
                number = Optional.of(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
        return number.get();
    }

    /**
     * Get the starting balance from the user
     *
     * @return an int that user input
     */
    public int inputBalance() {
        Optional<Integer> balance = Optional.empty();
        while (balance.isEmpty()) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input > 0){
                    balance = Optional.of(input);
                } else {
                    System.out.println("Your balance has to be greater than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
        return balance.get();
    }

    public void displayBalance(int balance) {
        String balanceString = Integer.toString(balance);
        StringBuilder formatted = new StringBuilder();

        int length = balanceString.length();
        for (int i = 0; i < length; i++) {
            formatted.append(balanceString.charAt(i));
            if ((length - i - 1) % 3 == 0 && i != length - 1) {
                formatted.append(" ");
            }
        }
        System.out.println("Current Balance: " + formatted + "$");
    }

    public void displayWinnings(int winnings, int bet) {
        if (winnings > bet){
            System.out.println("You won " + winnings + "$");
        }else if (winnings == 0){
            System.out.println("You lost " + bet + "$");
        }else if (winnings == bet){
            System.out.println("Draw! You get your" + bet + "back!");
        }
    }
}
