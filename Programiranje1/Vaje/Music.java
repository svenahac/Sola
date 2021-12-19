import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Music {
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Scanner sc = new Scanner(System.in);
        File file = new File("theme.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        String pog = sc.next();
        
    }
}
