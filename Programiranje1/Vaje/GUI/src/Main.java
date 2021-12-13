import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setSize(800, 600);

        JButton button = new JButton("Hello");
        JButton button2 = new JButton("Pog");

        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        north.add(button);
        north.add(button2);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(9,9));

        Listener listener = new Listener();
        Random random = new Random();
        String abeceda = "ABCDEFGHIJKLMNOPRSTUVZ";

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int randChar = random.nextInt(abeceda.length());
                JButton b = new JButton("" + abeceda.charAt(randChar));
                b.setBackground(new Color(4443433));
                b.addActionListener(listener);
                center.add(b);
            }
        }
        okno.add(center);

        okno.add(north, BorderLayout.NORTH);
        okno.setDefaultCloseOperation(3);
        okno.setVisible(true);

    }
}
