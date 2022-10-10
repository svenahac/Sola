package Screens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HighScore {
    public static String HighScore() {
        String myHS = "1";
        try {
            File myObj = new File("src/Content/highscore.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                myHS = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException ev) {
            System.out.println("An error occurred.");
            ev.printStackTrace();
        }

        return myHS;
    }
}
