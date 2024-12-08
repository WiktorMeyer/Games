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
        System.out.println("Welcome to Casino!");
        System.out.println("What is your balance?");
        setBalance(inputBalance());
        System.out.println("What do you want to play?");
    }

    public static int inputBalance() {
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
