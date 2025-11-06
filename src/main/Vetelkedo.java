package main;

import controller.GameController;
import view.GameViewGui;

public class Vetelkedo {
    public static void main(String[] args) {
        GameViewGui nezet = new GameViewGui();
        new GameController(nezet);
        nezet.setVisible(true);
    }
}
