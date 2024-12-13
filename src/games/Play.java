package games;

import games.controller.CasinoController;

/**
 * Just a class to start playing
 */
public class Play {

    public static void main(String[] args) {
        CasinoController casinoController = new CasinoController();
        casinoController.playCasino();
    }
}
