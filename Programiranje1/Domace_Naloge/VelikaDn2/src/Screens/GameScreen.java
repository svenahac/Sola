package Screens;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import Listeners.*;

public class GameScreen extends JFrame {
    public static JTextArea word;
    public GameScreen() {
        this.setSize(1300, 700);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Word Search");
        ImageIcon ico = new ImageIcon(getClass().getResource("/Content/heart.png"));
        this.setIconImage(ico.getImage());
        ImageIcon bg = new ImageIcon(getClass().getResource("/Content/wallpaper2.gif"));
        JLabel bgLabel = new JLabel(bg);

        JPanel gameBoard = new JPanel();
        gameBoard.setSize(1000, 600);
        gameBoard.setBackground(new Color(0, 0, 0, 200));
        gameBoard.setLocation(5, 5);

        JButton settings = new JButton("Settings");
        ButtonSettings(settings);
        settings.setLocation(1045, 478);
        settings.addActionListener(new SettingsListener());
        //Exit
        JButton exit = new JButton("Exit");
        ButtonSettings(exit);
        exit.setLocation(1045, 543);
        exit.addActionListener(new ExitListener());

        int rows = 9;
        int col = 9;

        gameBoard.setLayout(new GridLayout(rows, col));

        Random random = new Random();
        String abeceda = "ABCDEFGHIJKLMNOPRSTUVZQWY";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                int randChar = random.nextInt(abeceda.length());
                JButton b = new JButton("" + abeceda.charAt(randChar));
                b.setFocusable(false);
                b.setBackground(Color.WHITE);
                b.addActionListener(new GameButton());
                gameBoard.add(b);
            }
        }

        JTextArea word = new JTextArea("");
        word.setSize(200, 50);
        word.setLocation(405, 610);
        word.setEditable(false);
        word.setFont(word.getFont().deriveFont(20f));
        this.word= word;

        word.getText();

        JButton check = new JButton("Check");
        check.setSize(200, 50);
        check.setBackground(new Color(191,76,191));
        check.setFocusable(false);
        check.setLocation(610, 610);
        check.addActionListener(new CheckListener());

        ArrayList<String> dictionary = new ArrayList<String>();

        File file = new File("src/Content/dictionary.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                dictionary.add(sc.nextLine().toUpperCase());
            }
            sc.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        bgLabel.add(check);
        bgLabel.add(word);
        bgLabel.add(settings);
        bgLabel.add(exit);
        bgLabel.add(gameBoard);
        this.add(bgLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void ButtonSettings(JButton b){
        b.setSize(200, 60);
        b.setBackground(new Color(191,76,191));
        b.setFocusable(false);
    }

}
