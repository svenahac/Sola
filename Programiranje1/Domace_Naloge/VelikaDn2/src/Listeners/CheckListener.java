package Listeners;

import Screens.GameScreen;
import Screens.Rules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static Screens.GameScreen.*;
import static Screens.GameScreen.buttons;

public class CheckListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String checkedWord = word.getText();
        System.out.println(checkedWord);

        if(checkedWord.length() <= 2){
            JOptionPane.showMessageDialog(null, "The Word needs to be longer than 2.");
        } else {
            word.setText("");
            int flag = 0;
            for (int i = 0; i < dictionary.size(); i++) {
                if(dictionary.get(i).equals(checkedWord)){
                    flag = 1;
                }
            }
            if (flag == 1){
                System.out.println("Found it!");
                int current = Integer.parseInt(displayPoints.getText());
                int next = current + (int)(Math.pow(2,checkedWord.length()));
                displayPoints.setText(String.valueOf(next));
            } else {
                System.out.println("Wrong word!");
            }
            Random rand = new Random();
            int r = rand.nextInt(rows);
            int c = rand.nextInt(col);
            while (true){
                if (!clickedArray[r][c]){
                    clickedArray[r][c] = true;
                    Rules.clear(buttons);
                    Rules.availableMoves(r,c,buttons);
                    buttons[r][c].setBackground(Color.BLACK);
                    buttons[r][c].setEnabled(false);
                    String letter = buttons[r][c].getText();
                    word.append(letter);
                    break;
                } else {
                    r = rand.nextInt(rows);
                    c = rand.nextInt(col);
                }
            }

        }

    }
}
