package Screens;

import Listeners.*;

import javax.swing.*;
import java.awt.*;


public class EndScreen extends JFrame {
    public static JFrame endScreen;

    public EndScreen(){
        endScreen = this;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("End Screen");
        ImageIcon ico = new ImageIcon(getClass().getResource("/Content/heart.png"));
        this.setIconImage(ico.getImage());
        ImageIcon bg = new ImageIcon(getClass().getResource("/Content/wallpaper2.gif"));
        JLabel bgLabel = new JLabel(bg);
        // Play Again button
        JButton playAgain = new JButton("Play again");
        ButtonSettings(playAgain);
        playAgain.setLocation(250, 100);
        playAgain.addActionListener(new NewGameListener());

        // Settings
        JButton settings = new JButton("Settings");
        ButtonSettings(settings);
        settings.setLocation(250, 165);
        settings.addActionListener(new SettingsListener());

        //Exit button
        JButton exit = new JButton("Exit");
        ButtonSettings(exit);
        exit.setLocation(250, 230);
        exit.addActionListener(new ExitListener());

        // Score
        JPanel score = new JPanel();
        score.setLayout(new FlowLayout());
        score.setSize(250,60);
        score.setLocation(225,10);

        JLabel hs = new JLabel("Highscore: " + HighScore.HighScore(),SwingConstants.CENTER);
        System.out.println(HighScore.HighScore());
        hs.setFont(hs.getFont().deriveFont(30f));

        score.add(hs);
        bgLabel.add(score);
        bgLabel.add(exit);
        bgLabel.add(playAgain);
        bgLabel.add(settings);

        this.add(bgLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    public void ButtonSettings(JButton b){
        b.setSize(200, 60);
        b.setBackground(new Color(191,76,191));
        b.setFocusable(false);
    }
}
