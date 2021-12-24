package Screens;

import javax.swing.*;
import java.awt.*;
import Listeners.*;

public class StartScreen extends JFrame {
    public static JFrame startScreen;

    public StartScreen(){
        startScreen = this;
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("Game");
        this.setDefaultCloseOperation(3);
        // Sets an icon for the frame
        ImageIcon ico = new ImageIcon(getClass().getResource("/Images/heart.png"));
        this.setIconImage(ico.getImage());
        //----------------------------------------------------------------//
        // Background
        ImageIcon bg = new ImageIcon(getClass().getResource("/Images/wp2.gif"));
        JLabel bgLabel = new JLabel(bg);

        //----------------------------------------------------------------//
        // Play, Settings, Exit Buttons
        //Play
        JButton play = new JButton("Play");
        ButtonSettings(play);
        play.setLocation(150, 150);
        play.addActionListener(new PlayListener());
        //Settings
        JButton settings = new JButton("Settings");
        ButtonSettings(settings);
        settings.setLocation(150, 200);
        settings.addActionListener(new SettingsListener());
        //Exit
        JButton exit = new JButton("Exit");
        ButtonSettings(exit);
        exit.setLocation(150, 250);
        exit.addActionListener(new ExitListener());
        // Adding the buttons on screen
        bgLabel.add(play);
        bgLabel.add(settings);
        bgLabel.add(exit);
        this.add(bgLabel);

        //----------------------------------------------------------------//
        // Makes The window appear in the middle
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void ButtonSettings(JButton b){
        b.setSize(160, 40);
        b.setBackground(new Color(191,76,191));
        b.setFocusable(false);
    }

}
