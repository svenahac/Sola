package Listeners;

import Screens.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.GameScreen.gameScreen;
import static Screens.EndScreen.endScreen;

public class NewGameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        gameScreen.setVisible(false);
        endScreen.setVisible(false);
        new GameScreen();
    }
}
