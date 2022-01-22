package Listeners;

import Screens.GameScreen;
import Screens.Rules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.GameScreen.*;


public class GameButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        clicked.setBackground(Color.BLACK);
        clicked.setEnabled(false);
        String letter = clicked.getText();
        System.out.println(letter);
        GameScreen.word.append(letter);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if(e.getSource() == buttons[i][j]){
                    clickedArray[i][j] = true;
                    Rules.clear(buttons);
                    Rules.availableMoves(i,j,buttons);
                }
            }
        }

    }

}
