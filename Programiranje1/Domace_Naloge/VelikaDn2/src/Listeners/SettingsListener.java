package Listeners;

import Screens.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.GameScreen.gameScreen;
import static Screens.SettingsScreen.setScreen;
import static Screens.StartScreen.startScreen;

public class SettingsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        setScreen.setVisible(true);
    }
}