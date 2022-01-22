package Screens;

import javax.swing.*;
import Listeners.*;
import java.awt.*;
import static Screens.StartScreen.startScreen;

public class SettingsScreen extends JFrame {
    
    public static JFrame setScreen;
    public static JSlider fieldSlider;
    public static JLabel fieldLabel;
    public static JSlider colSlider;
    public static JLabel colLabel;
    public static JSlider volSlider;
    public static JLabel volLabel;
    public static  JLabel bgLabel;
    public SettingsScreen(){
        setScreen = this;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Settings");
        // Sets an icon for the frame
        ImageIcon ico = new ImageIcon(getClass().getResource("/Content/settings.png"));
        this.setIconImage(ico.getImage());
        String image = "/Content/wp2.gif";

        ImageIcon bg = new ImageIcon(getClass().getResource(image));
        JLabel bgLabel = new JLabel(bg);
        this.bgLabel = bgLabel;

        //Close button
        JButton close = new JButton("Close");
        ButtonSettings(close);
        close.setLocation(550, 400);
        close.addActionListener(new CloseListener());

        //--------------------SLIDER FOR FIELD SIZE-----------------------------------------------
        JSlider fieldSlider = new JSlider(2,20,10);
        fieldSlider.setMajorTickSpacing(5);
        fieldSlider.setPaintTicks(true);
        fieldSlider.addChangeListener(new RowSlider());
        this.fieldSlider = fieldSlider;

        JLabel fieldLabel = new JLabel();
        fieldLabel.setText(fieldSlider.getValue() + "x" + fieldSlider.getValue());
        this.fieldLabel = fieldLabel;

        JLabel fieldTitle = new JLabel("Game Field Size");


        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new FlowLayout());
        fieldPanel.setLocation(140,50);
        fieldPanel.setSize(200,80);
        fieldPanel.add(fieldTitle);
        fieldPanel.add(fieldSlider);
        fieldPanel.add(fieldLabel);
        //---------------------------------------------------------------------------------------
        //--------------------SLIDER FOR VOLUME-------------------------------------------
        JSlider volSlider = new JSlider(0,100,50);
        volSlider.setMajorTickSpacing(10);
        volSlider.setPaintTicks(true);
        volSlider.addChangeListener(new VolSlider());
        this.volSlider = volSlider;

        JLabel volLabel = new JLabel();
        volLabel.setText("Value: " + volSlider.getValue() + "%");
        this.volLabel = volLabel;

        JLabel volTitle = new JLabel("Set Volume");

        JPanel volPanel = new JPanel();
        volPanel.setLayout(new FlowLayout());
        volPanel.setLocation(360,50);
        volPanel.setSize(200,80);
        volPanel.add(volTitle);
        volPanel.add(volSlider);
        volPanel.add(volLabel);
        //-------------------------------------------------------------------------------------------------
        bgLabel.add(fieldPanel);
        bgLabel.add(volPanel);
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
