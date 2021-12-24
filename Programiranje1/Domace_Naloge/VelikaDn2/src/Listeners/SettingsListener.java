package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Screens.*;

public class SettingsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new SettingsScreen();

    }
}