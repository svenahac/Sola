package Listeners;

import Screens.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.GameScreen.gameScreen;

public class NewGameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        gameScreen.setVisible(false);
        new GameScreen();
    }
}
