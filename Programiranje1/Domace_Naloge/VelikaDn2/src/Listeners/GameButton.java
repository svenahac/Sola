package Listeners;

import Screens.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        clicked.setBackground(Color.BLACK);
        clicked.setEnabled(false);
        String letter = clicked.getText();
        System.out.println(letter);
        GameScreen.word.append(letter);
    }
}
