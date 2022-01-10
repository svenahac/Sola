package Listeners;

import Screens.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String checkedWord = GameScreen.word.getText();
        System.out.println(checkedWord);
        GameScreen.word.setText("");
    }
}
