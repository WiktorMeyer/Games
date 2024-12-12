package games.model;

import java.util.Optional;
import java.util.Scanner;

public class Casino {
    private int balance;
    private static final Scanner scanner = new Scanner(System.in);
    private final Slots slots;
    private final GuessNumber guessNumber;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Casino() {
        this.slots = new Slots(this);
        guessNumber = new GuessNumber(this);
    }

    public static void main(String[] args) {
        Casino casino = new Casino();
        casino.playCasino();
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

    /**
     * A method to get a number from a user
     * @return number input by the user
     */
    public int getNumber() {
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
     * Get a boolean from the user
     * @return true/false
     */
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


}
