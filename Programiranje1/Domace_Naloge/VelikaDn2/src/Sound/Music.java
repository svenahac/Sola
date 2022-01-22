package Sound;

import javax.sound.sampled.*;
import java.io.File;

public class Music {
    public static FloatControl control;
    public Music() {

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("./src/Sound/theme.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            control.setValue(-20);
            this.control = control;
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
