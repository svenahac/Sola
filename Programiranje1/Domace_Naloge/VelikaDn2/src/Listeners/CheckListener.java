package Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.GameScreen.dictionary;
import static Screens.GameScreen.word;
import static Screens.GameScreen.displayPoints;

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
        }

    }
}
