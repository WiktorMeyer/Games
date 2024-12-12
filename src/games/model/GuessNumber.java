package games.model;

/**
 * A simple guess number game
 * You input the number to the console until you
 * guess the number that was generated randomly
 * By default the number are in [1,10] range
 */
//TODO: implement playing for money

public class GuessNumber{

    private final int MIN;
    private final int MAX;

    public GuessNumber() {
        this.MIN = 1;
        this.MAX = 10;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }

    /**
     *
     * @param min lower bound of the interval
     * @param max upper bound of the interval
     * @return an integer between min and max inclusive
     */
    public int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
