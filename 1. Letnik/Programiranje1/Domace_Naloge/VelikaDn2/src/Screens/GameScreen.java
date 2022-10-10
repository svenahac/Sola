package Screens;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import Listeners.*;

import static Screens.SettingsScreen.*;

public class GameScreen extends JFrame {
    public static JTextArea word;
    public static ArrayList<String> dictionary;
    public static JLabel displayPoints;
    public static JFrame gameScreen;
    public static boolean[][] clickedArray;
    public static int rows;
    public static int col;
    public static JButton[][] buttons;

    public GameScreen() {
        gameScreen = this;
        this.setSize(1300, 700);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Word Search");
        ImageIcon ico = new ImageIcon(getClass().getResource("/Content/heart.png"));
        this.setIconImage(ico.getImage());
        ImageIcon bg = new ImageIcon(getClass().getResource("/Content/wallpaper2.gif"));
        JLabel bgLabel = new JLabel(bg);

        // Gameboard
        JPanel gameBoard = new JPanel();
        gameBoard.setSize(1000, 600);
        gameBoard.setBackground(new Color(0, 0, 0, 200));
        gameBoard.setLocation(5, 5);
        // New Game
        JButton newGame = new JButton("New Game");
        ButtonSettings(newGame);
        newGame.setLocation(1045, 348);
        newGame.addActionListener(new NewGameListener());
        // End Game
        JButton endGame = new JButton("End Game");
        ButtonSettings(endGame);
        endGame.setLocation(1045, 413);
        endGame.addActionListener(new EndListener());
        // Settings
        JButton settings = new JButton("Settings");
        ButtonSettings(settings);
        settings.setLocation(1045, 478);
        settings.addActionListener(new SettingsListener());
        // Exit
        JButton exit = new JButton("Exit");
        ButtonSettings(exit);
        exit.setLocation(1045, 543);
        exit.addActionListener(new ExitListener() );

        int rows = fieldSlider.getValue();
        int col = fieldSlider.getValue();
        this.rows = rows;
        this.col = col;



        JTextArea word = new JTextArea("");
        word.setSize(200, 50);
        word.setLocation(405, 610);
        word.setEditable(false);
        word.setFont(word.getFont().deriveFont(20f));
        this.word= word;

        gameBoard.setLayout(new GridLayout(rows, col));
        Random random = new Random();

        int randI = random.nextInt(rows);
        int randJ = random.nextInt(col);

        boolean[][] clickedArray = new boolean[rows][col];

        this.clickedArray = clickedArray;

        JButton[][] buttons = new JButton[rows][col];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                JButton b = new JButton("" + BetterAlphabet.randomChar());
                b.setFocusable(false);
                b.setBackground(Color.WHITE);
                b.addActionListener(new GameButton());
                b.setEnabled(false);
                buttons[i][j] = b;

                gameBoard.add(b);
            }
        }
        this.buttons = buttons;
        ClickButton(buttons[randI][randJ]);
        clickedArray[randI][randJ] = true;
        Rules.availableMoves(randI,randJ,buttons);


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
        this.dictionary=dictionary;

        JLabel points = new JLabel("Points", SwingConstants.CENTER);
        points.setSize(200,20);
        points.setLocation(1045,5);
        points.setFont(points.getFont().deriveFont(25f));
        points.setForeground(Color.WHITE);

        JTextArea displayP = new JTextArea();
        displayP.setSize(200,60);
        displayP.setLocation(1045,30);
        displayP.setBackground(Color.WHITE);

        JLabel displayPoints = new JLabel("0",SwingConstants.CENTER);
        displayPoints.setFont(displayPoints.getFont().deriveFont(25f));
        displayPoints.setSize(200,60);
        displayPoints.setLocation(1045,30);
        displayPoints.setBackground(Color.BLACK);
        this.displayPoints = displayPoints;

        bgLabel.add(points);
        bgLabel.add(displayPoints);
        bgLabel.add(displayP);

        bgLabel.add(check);
        bgLabel.add(word);
        bgLabel.add(newGame);
        bgLabel.add(endGame);
        bgLabel.add(settings);
        bgLabel.add(exit);
        bgLabel.add(gameBoard);


        this.add(bgLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void ClickButton(JButton b) {
        b.setBackground(Color.BLACK);
        b.setEnabled(false);
        String letter = b.getText();
        word.append(letter);
    }

    public void ButtonSettings(JButton b){
        b.setSize(200, 60);
        b.setBackground(new Color(191,76,191));
        b.setFocusable(false);
    }

    public boolean isClicked(){
        return true;
    }

}
