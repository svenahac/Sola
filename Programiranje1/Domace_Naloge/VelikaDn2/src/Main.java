import Screens.*;
import Sound.*;

import static Screens.SettingsScreen.setScreen;

public class Main {

    public static void main(String[] args) {
        new StartScreen();
        new SettingsScreen();
        new Music();
        new EndScreen();
        
    }
}
