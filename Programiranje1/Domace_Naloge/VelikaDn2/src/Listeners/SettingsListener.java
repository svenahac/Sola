package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.SettingsScreen.setScreen;

public class SettingsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        setScreen.setVisible(true);

    }
}