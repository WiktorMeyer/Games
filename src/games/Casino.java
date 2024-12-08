package games;

import java.util.Optional;
import java.util.Scanner;

public class Casino {
    private int balance;
    private static Scanner scanner = new Scanner(System.in);
    private Slots slots;
    private GuessNumber guessNumber;

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
        casino.startCasino();
    }

    public void startCasino(){
        int choice;
        System.out.println("Welcome to Casino!");
        System.out.println("What is your balance?");
        setBalance(inputBalance());
        while (true) {
            System.out.println("What do you want to play?");
            System.out.println("Press 1 for Blackjack");
            System.out.println("Press 2 for Guess Number");
            System.out.println("Press 3 for Slots");
            choice = getNumber();
            if (choice == 1){
                //TODO: play Blackjack
            } else if (choice == 2){
                //TODO: play Guess Number
            } else if (choice == 3){
                try {
                    slots.playSlots();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid choice");
            }

        }
    }

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
     * Assert if the player want to play again
     * @return true/false
     */
    public boolean playAgain(){
        while (true) {
            try {
                if (scanner.nextLine().equalsIgnoreCase("y")){
                    return true;
                }else{
                    System.out.println("Enter y or n");
                }
            } catch (Exception e) {
                System.out.println("Enter y or n");
            }
        }
    }


}
