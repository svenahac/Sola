package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.SettingsScreen.setScreen;


public class CloseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        setScreen.setVisible(false);

    }
}