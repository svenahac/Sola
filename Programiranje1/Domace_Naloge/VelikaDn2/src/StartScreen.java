import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen {
    public void ButtonSettings(JButton b){
        b.setSize(160, 40);
        b.setBackground(new Color(191,76,191));
        b.setFocusable(false);
    }

    public void Start(){
        JFrame startScreen = new JFrame();
        startScreen.setSize(800, 600);
        startScreen.setResizable(false);
        startScreen.setTitle("Game");
        startScreen.setDefaultCloseOperation(3);
        // Sets an icon for the frame
        ImageIcon ico = new ImageIcon(getClass().getResource("/Images/heart.png"));
        startScreen.setIconImage(ico.getImage());
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
        //exit.addActionListener(new ExitListener());
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
        startScreen.add(bgLabel);

        //----------------------------------------------------------------//
        // Makes The window appear in the middle
        startScreen.setLocationRelativeTo(null);
        startScreen.setVisible(true);
    }
}