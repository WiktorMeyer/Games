package games.controller;

import games.model.BlackJack;
import games.view.TUI.BlackJackView;

public class BlackJackController {

    private final BlackJack model;
    private final BlackJackView view;

    public BlackJackController() {
        this.view = new BlackJackView();
        this.model = new BlackJack();
    }
}
