package Screens;

import javax.swing.*;
import Listeners.*;
import java.awt.*;
import static Screens.StartScreen.startScreen;

public class SettingsScreen extends JFrame {
    
    public static JFrame setScreen;
    public static JSlider rowSlider;
    public static JLabel rowLabel;
    public static JSlider colSlider;
    public static JLabel colLabel;
    public static JSlider volSlider;
    public static JLabel volLabel;

    public SettingsScreen(){
        setScreen = this;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Settings");
        // Sets an icon for the frame
        ImageIcon ico = new ImageIcon(getClass().getResource("/Content/settings.png"));
        this.setIconImage(ico.getImage());
        String image;
        if (startScreen.isVisible()) {
            image = "/Content/wp2.gif";
        } else {
            image = "/Content/wallpaper2.gif";
        }
        ImageIcon bg = new ImageIcon(getClass().getResource(image));
        JLabel bgLabel = new JLabel(bg);

        //Close button
        JButton close = new JButton("Close");
        ButtonSettings(close);
        close.setLocation(550, 400);
        close.addActionListener(new CloseListener());

        //--------------------SLIDER FOR ROWS-----------------------------------------------
        JSlider rowSlider = new JSlider(2,20,10);
        rowSlider.setMajorTickSpacing(5);
        rowSlider.setPaintTicks(true);
        rowSlider.addChangeListener(new RowSlider());
        this.rowSlider = rowSlider;

        JLabel rowLabel = new JLabel();
        rowLabel.setText("Value: " + rowSlider.getValue());
        this.rowLabel = rowLabel;

        JLabel rowTitle = new JLabel("Row Size");


        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(new FlowLayout());
        rowPanel.setLocation(140,5);
        rowPanel.setSize(200,80);
        rowPanel.add(rowTitle);
        rowPanel.add(rowSlider);
        rowPanel.add(rowLabel);
        //---------------------------------------------------------------------------------------
        //--------------------SLIDER FOR COLUMNS-------------------------------------------
        JSlider colSlider = new JSlider(2,20,10);
        colSlider.setMajorTickSpacing(5);
        colSlider.setPaintTicks(true);
        colSlider.addChangeListener(new ColSlider());
        this.colSlider= colSlider;

        JLabel colLabel = new JLabel();
        colLabel.setText("Value: " + colSlider.getValue());
        this.colLabel = colLabel;

        JLabel colTitle = new JLabel("Column Size");

        JPanel colPanel = new JPanel();
        colPanel.setLayout(new FlowLayout());
        colPanel.setLocation(360,5);
        colPanel.setSize(200,80);
        colPanel.add(colTitle);
        colPanel.add(colSlider);
        colPanel.add(colLabel);
        //-------------------------------------------------------------------------------------------------
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
        volPanel.setLocation(250,95);
        volPanel.setSize(200,80);
        volPanel.add(volTitle);
        volPanel.add(volSlider);
        volPanel.add(volLabel);
        //-------------------------------------------------------------------------------------------------
        bgLabel.add(rowPanel);
        bgLabel.add(colPanel);
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
