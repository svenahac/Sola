import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsListener extends StartScreen implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new SettingsScreen();

    }
}
