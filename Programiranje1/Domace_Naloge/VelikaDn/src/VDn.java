import java.util.*;

public class VDn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Koliko števil boš vnesel? ");
        int vnos = sc.nextInt();
        if (vnos != 0) {
            int[] tab_stevil = new int[vnos];
            for (int i = 0; i < vnos; i++) {
                tab_stevil[i] = sc.nextInt();
            }
            // Ustvari novo tabelo, da jo lahko potem sortiram
            int[] sortirana = new int[tab_stevil.length];
            for (int i = 0; i < tab_stevil.length; i++) {
                sortirana[i] = tab_stevil[i];
            }
            // Sortiram tabelo
            Helper.sortiraj(sortirana);
            // število elementov (števil)
            System.out.println("Število elementov: " + tab_stevil.length);
            // število različnih števil
            Helper.stRazlicnih(sortirana);
            // število sodih in lihih števil
            Helper.stSodihLihih(tab_stevil);
            // frekvenco pojavitev vsakega števila (v procentih) in število ki se največkrat ponovi
            Helper.frekvenca(tab_stevil);
            // največje število
            System.out.println("Največje število je: " + sortirana[sortirana.length-1]);
            // drugo najmanjšo vrednost števil
            if (sortirana.length <= 1){
                System.out.println("Druga najmanjša vrednost števil je: " + sortirana[0]);
            } else {
                System.out.println("Druga najmanjša vrednost števil je: " + sortirana[1]);
            }
            // povprečje vseh števil
            System.out.println("Povprečje je: " + Helper.povprecje(tab_stevil));
            // standardni odklon
            Helper.standardniOdklon(tab_stevil);
            // mediana
            Helper.mediana(sortirana);
            // vsota vseh števil
            Helper.vsota(tab_stevil);
            // koliko palindromov
            Helper.kolikoPalindromov(tab_stevil);
            // Največji palindrom
            Helper.najPalindrom(sortirana);
            // Obratno izpisana števila
            Helper.rikverc(tab_stevil);
        }
    }
}
