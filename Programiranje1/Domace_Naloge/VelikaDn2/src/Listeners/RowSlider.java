package Listeners;

import javax.swing.event.ChangeEvent;

import static Screens.SettingsScreen.rowLabel;
import static Screens.SettingsScreen.rowSlider;

public class RowSlider implements javax.swing.event.ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        rowLabel.setText("Value: " + rowSlider.getValue());
    }
}
