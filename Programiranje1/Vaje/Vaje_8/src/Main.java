import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Random random = new Random();
        Flake flakes[] = new Flake[100];
        for (int i = 0; i < flakes.length; i++) {
            int size = 6 + random.nextInt(14);
            flakes[i] = new Flake(random.nextInt(800), random.nextInt(600), size);
        }
        JPanel panel = new JPanel(){
          @Override
          protected void paintComponent(Graphics g) {
              g.setColor(Color.BLACK);
              g.fillRect(0,0,800,600);
              for (int i = 0; i < flakes.length; i++) {
                  flakes[i].fall();
                  flakes[i].draw(g);
              }
              g.setColor(new Color(0xB43C32));
              g.setFont(new Font("Herculanum", Font.BOLD, 38));
              //g.drawString("Happy New Year", 240, 200);
              try {
                  Thread.sleep(23);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              super.repaint();
          }

        };
        frame.add(panel);
        //frame.setResizable(false);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
