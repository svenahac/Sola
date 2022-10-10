import java.awt.*;
import java.util.Random;

public class Flake {
    float x;
    float y;
    int size;
    int detail = 8;
    float speed = 0f;
    double counter = 0f;

    public Flake(float x, float y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = size;
    }

    public void fall(){
        if(y>600){
            y = -20;
        }
        y += speed;
        counter += 0.01;
        double deltaX = Math.cos(counter + size) * 2;
        x+=deltaX;
    }

    public void draw(Graphics g) {
        double turn = Math.toRadians(360/detail);
        Graphics2D g2d = (Graphics2D) g;
        Random random = new Random();
        g2d.setColor(new Color(random.nextInt()));
        g2d.setStroke(new BasicStroke(3));
        for (int i = 1; i < detail+1; i++) {
            g2d.rotate(turn, x, y);
            g2d.drawLine((int)x, (int)y, (int)x + size, (int)y + size);
        }
    }
}
