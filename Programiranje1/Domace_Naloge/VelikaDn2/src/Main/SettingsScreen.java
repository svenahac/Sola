package Main;

import javax.swing.*;
import Listeners.*;

import static Main.StartScreen.startScreen;

public class SettingsScreen extends JFrame {
    
    public static JFrame setScreen;

    public SettingsScreen(){
        setScreen = this;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Settings");
        // Sets an icon for the frame
        ImageIcon ico = new ImageIcon(getClass().getResource("/Images/settings.png"));
        this.setIconImage(ico.getImage());
        String image;
        if (startScreen.isVisible()) {
            image = "/Images/wp2.gif";
        } else {
            image = "/Images/wallpaper2.gif";
        }
        ImageIcon bg = new ImageIcon(getClass().getResource(image));
        JLabel bgLabel = new JLabel(bg);

        JButton close = new JButton("Close");
        close.setSize(100, 40);
        close.setFocusable(false);
        close.setLocation(550, 400);
        close.addActionListener(new CloseListener());
        bgLabel.add(close);
        this.add(bgLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
