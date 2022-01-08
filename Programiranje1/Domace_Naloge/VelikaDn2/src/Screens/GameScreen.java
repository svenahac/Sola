package Screens;

import javax.swing.*;
import java.awt.*;

import Listeners.*;

public class GameScreen extends JFrame {
    public GameScreen(){
        this.setSize(800, 600);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Settings");
        ImageIcon ico = new ImageIcon(getClass().getResource("/Images/heart.png"));
        this.setIconImage(ico.getImage());
        ImageIcon bg = new ImageIcon(getClass().getResource("/Images/wallpaper2.gif"));
        JLabel bgLabel = new JLabel(bg);

        JPanel gameBoard = new JPanel();
        gameBoard.setSize(600, 500);
        gameBoard.setBackground(new Color(0, 0, 0, 200));
        gameBoard.setLocation(5,5);

        JButton settings = new JButton("Settings");
        ButtonSettings(settings);
        settings.setLocation(615, 415);
        settings.addActionListener(new SettingsListener());
        //Exit
        JButton exit = new JButton("Exit");
        ButtonSettings(exit);
        exit.setLocation(615, 465);
        exit.addActionListener(new ExitListener());
        gameBoard.setLayout(new GridLayout(9,9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton b = new JButton();
                b.setBackground(Color.WHITE);
                b.addActionListener(new GameButton());
                gameBoard.add(b);
            }
        }

        bgLabel.add(settings);
        bgLabel.add(exit);
        bgLabel.add(gameBoard);
        this.add(bgLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void ButtonSettings(JButton b){
        b.setSize(160, 40);
        b.setBackground(new Color(191,76,191));
        b.setFocusable(false);
    }

}
