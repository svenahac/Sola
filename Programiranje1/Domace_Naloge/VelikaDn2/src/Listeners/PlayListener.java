package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Screens.*;

import static Screens.StartScreen.startScreen;
import static Screens.SettingsScreen.image;

public class PlayListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        startScreen.setVisible(false);
        new GameScreen();
        image = "/Content/wallpaper2.gif";

    }
}
