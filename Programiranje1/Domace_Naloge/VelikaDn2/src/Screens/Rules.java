package Screens;

import javax.swing.*;
import java.awt.*;

import static Screens.GameScreen.*;

public class Rules {

    public static void availableMoves(int i, int j, JButton[][] buttons){

        if (i == 0 && j == 0) { // Top left corner

            makeClickable(buttons[i][j+1], i, j+1); // Row 2, Col 3
            makeClickable(buttons[i+1][j], i+1, j); // Row 3, Col 2
            makeClickable(buttons[i+1][j+1], i+1, j+1); // Row 3, Col 3

        } else if(i == col-1 && j == 0) { // Bottom left corner

            makeClickable(buttons[i - 1][j], i - 1, j); // Row 1, Col 2
            makeClickable(buttons[i - 1][j + 1], i - 1, j + 1); // Row 1, Col 3
            makeClickable(buttons[i][j + 1], i, j + 1); // Row 2, Col 3

        } else if (i == 0 && j == rows-1) { // Top right corner

            makeClickable(buttons[i][j - 1], i, j - 1); // Row 2, Col 1
            makeClickable(buttons[i + 1][j - 1], i + 1, j - 1); // Row 3, Col 1
            makeClickable(buttons[i + 1][j], i + 1, j); // Row 3, Col 2

        } else if (i == col-1 && j == rows-1) { // Bottom right corner

            makeClickable(buttons[i - 1][j - 1], i - 1, j - 1); // Row 1, Col 1
            makeClickable(buttons[i - 1][j], i - 1, j); // Row 1, Col 2
            makeClickable(buttons[i][j - 1], i, j - 1); // Row 2, Col 1

        } else if (i == 0 && j < rows-1 && j > 0) { // Top side

            makeClickable(buttons[i][j - 1], i, j - 1); // Row 2, Col 1
            makeClickable(buttons[i][j + 1], i, j + 1); // Row 2, Col 3
            makeClickable(buttons[i + 1][j - 1], i + 1, j - 1); // Row 3, Col 1
            makeClickable(buttons[i + 1][j], i + 1, j); // Row 3, Col 2
            makeClickable(buttons[i + 1][j + 1], i + 1, j + 1); // Row 3, Col 3

        }else if (i == col-1 && j < rows-1 && j > 0) { // Bottom side

            makeClickable(buttons[i - 1][j - 1], i - 1, j - 1); // Row 1, Col 1
            makeClickable(buttons[i - 1][j], i - 1, j); // Row 1, Col 2
            makeClickable(buttons[i - 1][j + 1], i - 1, j + 1); // Row 1, Col 3
            makeClickable(buttons[i][j - 1], i, j - 1); // Row 2, Col 1
            makeClickable(buttons[i][j + 1], i, j + 1); // Row 2, Col 3

        } else  if (j == 0 && i < col-1 && i > 0) { // Left Side

            makeClickable(buttons[i-1][j], i-1, j); // Row 1, Col 2
            makeClickable(buttons[i-1][j+1],i-1, j+1); // Row 1, Col 3
            makeClickable(buttons[i][j+1], i, j+1); // Row 2, Col 3
            makeClickable(buttons[i+1][j], i+1, j); // Row 3, Col 2
            makeClickable(buttons[i+1][j+1], i+1, j+1); // Row 3, Col 3

        } else if (j == rows-1 && i < col-1 && i > 0) { // Right Side

            makeClickable(buttons[i-1][j-1], i-1, j-1); // Row 1, Col 1
            makeClickable(buttons[i-1][j], i-1, j); // Row 1, Col 2
            makeClickable(buttons[i][j-1], i ,j-1); // Row 2, Col 1
            makeClickable(buttons[i+1][j-1], i+1, j-1); // Row 3, Col 1
            makeClickable(buttons[i+1][j], i+1, j); // Row 3, Col 2

        } else {

            makeClickable(buttons[i-1][j-1], i-1, j-1); // Row 1, Col 1
            makeClickable(buttons[i-1][j], i-1, j); // Row 1, Col 2
            makeClickable(buttons[i-1][j+1],i-1, j+1); // Row 1, Col 3

            makeClickable(buttons[i][j-1], i ,j-1); // Row 2, Col 1
            makeClickable(buttons[i][j+1], i, j+1); // Row 2, Col 3

            makeClickable(buttons[i+1][j-1], i+1, j-1); // Row 3, Col 1
            makeClickable(buttons[i+1][j], i+1, j); // Row 3, Col 2
            makeClickable(buttons[i+1][j+1], i+1, j+1); // Row 3, Col 3
        }

    }

    public static void makeClickable(JButton b, int i, int j){
        if (!clickedArray[i][j]){
            b.setEnabled(true);
            b.setBackground(Color.RED);
        }

    }
    public static void clear(JButton[][] buttons){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (!clickedArray[i][j]){
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setBackground(Color.white);
                }
            }
        }
    }
}
