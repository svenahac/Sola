package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Screens.EndScreen.*;
public class EndListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        endScreen.setVisible(true);
    }
}
