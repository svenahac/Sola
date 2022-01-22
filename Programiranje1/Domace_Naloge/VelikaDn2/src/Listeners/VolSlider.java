package Listeners;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static Screens.SettingsScreen.volLabel;
import static Screens.SettingsScreen.volSlider;
import static Sound.Music.control;

public class VolSlider implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        volLabel.setText("Value: " + volSlider.getValue() + "%");
        int volume = volSlider.getValue();
        float soundVolume = 0;
        if (volume == 50){
            soundVolume = -20;
        } else if (volume < 50) {
            soundVolume = (float) (-20 + (volume-50)*1.2);
        } else if (volume > 50) {
            soundVolume = (float) (- 20 + (volume-50)*0.4);
        }
        System.out.println(soundVolume);
        control.setValue(soundVolume);
    }
}
