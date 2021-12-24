package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Screens.*;

import static Screens.StartScreen.startScreen;

public class PlayListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        startScreen.setVisible(false);
        new GameScreen();

    }
}
