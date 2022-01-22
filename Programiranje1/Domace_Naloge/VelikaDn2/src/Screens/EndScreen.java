package Screens;

import Listeners.CloseListener;

import javax.swing.*;
import java.awt.*;

public class EndScreen extends JFrame {
    public static JFrame endScreen;
    public EndScreen(){
        endScreen = this;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("End Screen");
        ImageIcon ico = new ImageIcon(getClass().getResource("/Content/heart.png"));
        this.setIconImage(ico.getImage());
        ImageIcon bg = new ImageIcon(getClass().getResource("/Content/wallpaper2.gif"));
        JLabel bgLabel = new JLabel(bg);

        //Close button
        JButton close = new JButton("Close");
        ButtonSettings(close);
        close.setLocation(550, 400);
        close.addActionListener(new CloseListener());

        bgLabel.add(close);
        this.add(bgLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    public void ButtonSettings(JButton b){
        b.setSize(100, 40);
        b.setBackground(new Color(191,76,191));
        b.setFocusable(false);
    }
}
