package games;

import java.util.Optional;
import java.util.Scanner;

public class Casino {
    private int balance;
    private static Scanner scanner = new Scanner(System.in);

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Casino!");
        System.out.println("What is your balance?");
    }

    public static int inputBalance() {
        Optional<Integer> balance = Optional.empty();
        while (!balance.isPresent()) {
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
    }


}
