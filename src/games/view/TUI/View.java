package games.view.TUI;

import java.util.Optional;
import java.util.Scanner;

public abstract class View {

    protected final Scanner scanner = new Scanner(System.in);

    public void displayTy4Playing(){
        System.out.println("Thank you for playing!");
    }

    public abstract void displayWelcomeMessage();

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public int inputBet(int balance){
        Optional<Integer> bet = Optional.empty();

        while (bet.isEmpty()) {
            try{
                bet = Optional.of(Integer.parseInt(scanner.nextLine()));
                if (bet.get() > balance){
                    System.out.println("You don't have enough money!");
                    bet = Optional.empty();
                    System.out.println("Enter bet amount: ");
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

    public boolean getBoolean(){
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
                    return true;
                }else if( input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
                    return false;
                } else{
                    System.out.println("Enter y or n");
                }
            } catch (Exception e) {
                System.out.println("Enter y or n");
            }
        }
    }

    public void displayNoMoney(){
        System.out.println("You have no money in your wallet. :(");
    }

    public void displayPlayAgainQuestion(){
        System.out.println("Do you want to play again? (Y/N)");
    }

    /**
     * A method to get a number from a user
     * @return number input by the user
     */
    public int inputNumber() {
        Optional<Integer> number = Optional.empty();
        while (number.isEmpty()) {
            try{
                number = Optional.of(Integer.parseInt(scanner.nextLine()));
            }catch(NumberFormatException e){
                System.out.println("Please enter a number!");
            }
        }
        return number.get();
    }

    /**
     * Get the starting balance from the user
     * @return an int that user input
     */
    public int inputBalance() {
        Optional<Integer> balance = Optional.empty();
        while (balance.isEmpty()) {
            try{
                int input = Integer.parseInt(scanner.nextLine());
                if (input > 0){
                    balance = Optional.of(input);
                }else{
                    System.out.println("Your balance has to be greater than 0");
                }
            }catch(NumberFormatException e){
                System.out.println("Please enter a number!");
            }
        }
        return balance.get();
    }
}
