import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Music2 {
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Scanner sc = new Scanner(System.in);
        //File file = new File("theme.wav");
        //AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        //Clip clip = AudioSystem.getClip();
        //clip.open(audioStream);
        //clip.start();

        //String pog = sc.next();

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("theme.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            control.setValue(-40.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String pog = sc.next();
    }
}
