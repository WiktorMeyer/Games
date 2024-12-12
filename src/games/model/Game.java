package games.model;

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
}
