package Screens;

import java.util.Random;

public class BetterAlphabet {
    public static char randomChar () {
        Random random = new Random();
        int r = random.nextInt(100000);
        char myChar = 'A';

        // SPAGHETTI CODE FOR GENERATING RANDOM LETTERS BY PERCENTAGE OF APPEARANCE IN DICTIONARY
        if (r < 7564) {
            myChar = 'A';
        } else if(7564 < r && r <= 9431) {
            myChar = 'B';
        } else if(9431 < r && r <= 13540) {
            myChar = 'C';
        } else if(13540 < r && r <= 17537) {
            myChar = 'D';
        } else if(17537 < r && r <= 29094) {
            myChar = 'E';
        } else if(29094 < r && r <= 30513) {
            myChar = 'F';
        } else if(30513 < r && r <= 33464) {
            myChar = 'G';
        } else if(33464 < r && r <= 35611) {
            myChar = 'H';
        } else if(35611 < r && r <= 44409) {
            myChar = 'I';
        } else if(44409 < r && r <= 44576) {
            myChar = 'J';
        } else if(44576 < r && r <= 45390) {
            myChar = 'K';
        } else if(45390 < r && r <= 50838) {
            myChar = 'L';
        } else if(50838 < r && r <= 53510) {
            myChar = 'M';
        } else if(53510 < r && r <= 60625) {
            myChar = 'N';
        } else if(60625 < r && r <= 66621) {
            myChar = 'O';
        } else if(66621 < r && r <= 69535) {
            myChar = 'P';
        } else if(69535 < r && r <= 69715) {
            myChar = 'Q';
        } else if(69715 < r && r <= 76981) {
            myChar = 'R';
        } else if(76981 < r && r <= 85531) {
            myChar = 'S';
        } else if(85531 < r && r <= 92534) {
            myChar = 'T';
        } else if(92534 < r && r <= 95940) {
            myChar = 'U';
        } else if(95940 < r && r <= 96999) {
            myChar = 'V';
        } else if(96999 < r && r <= 97851) {
            myChar = 'W';
        } else if(97851 < r && r <= 98139) {
            myChar = 'X';
        } else if(98139 < r && r <= 99862) {
            myChar = 'Y';
        } else if(99862 < r && r <= 100000) {
            myChar = 'Z';
        }

        return myChar;
    }
}
