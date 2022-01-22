package Listeners;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static Screens.SettingsScreen.colLabel;
import static Screens.SettingsScreen.colSlider;

public class ColSlider implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        colLabel.setText("Value: " + colSlider.getValue());
    }
}
