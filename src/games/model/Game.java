package games.model;

import games.Casino;

import java.util.Optional;
import java.util.Scanner;

public abstract class Game {
    protected final Scanner scanner = new Scanner(System.in);
    private Casino casino;

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
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

}
