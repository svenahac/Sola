package Listeners;

import javax.swing.event.ChangeEvent;

import static Screens.SettingsScreen.fieldLabel;
import static Screens.SettingsScreen.fieldSlider;

public class RowSlider implements javax.swing.event.ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        fieldLabel.setText(fieldSlider.getValue() + "x" + fieldSlider.getValue());
    }
}
