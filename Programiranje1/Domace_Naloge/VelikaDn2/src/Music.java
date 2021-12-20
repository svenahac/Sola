import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Music {
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("/Sound/theme.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.drain();

    }
    Music() {
        try {
            URL url = this.getClass().getClassLoader().getResource("/Sound/theme.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
