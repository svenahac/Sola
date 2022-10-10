package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Screens.*;

import javax.swing.*;

import static Screens.StartScreen.startScreen;


public class PlayListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        startScreen.setVisible(false);
        new GameScreen();
        ImageIcon bg = new ImageIcon(getClass().getResource("/Content/wallpaper2.gif"));
        SettingsScreen.bgLabel.setIcon(bg);

    }
}
