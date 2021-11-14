import java.util.*;

public class VDn {
    public static void kolikoPalindromov(int[] tab) {
        int counter = 0;
        for (int i = 0; i < tab.length; i++) {
            if (palindrom(tab[i])) {
                counter++;
            }
        }
        System.out.println("Število palindromov je: " + counter);
    }
    public static boolean palindrom(int stevilo) {
        String a = Integer.toString(stevilo);
        StringBuilder ss = new StringBuilder(a);
        String tmp = ss.reverse().toString();
        if(tmp.contentEquals(a)) {
            return true;
        } else {
            return false;
        }
    }
    public static void vsota(int[] tab) {
        int vsota = 0;
        for (int i = 0; i < tab.length; i++) {
            vsota += tab[i];
        }
        System.out.println("Vsota vseh števil je: " + vsota);
    }
    public static void mediana(int[] tab) {
        if (tab.length % 2 != 0) {
            System.out.println("Mediana je: " + tab[tab.length/2]);
        } else {
            double medi = (tab[tab.length/2] + tab[(tab.length/2)-1])/2.0;
            System.out.println("Mediana je: " + medi);
        }
    }
    public static void standardniOdklon(int[] tab) {
        double povp = povprecje(tab);
        double vsota = 0.0;
        for (int i = 0; i < tab.length; i++) {
            vsota += Math.pow((tab[i] - povp), 2);
        }
        double odklon = Math.sqrt(vsota/tab.length);
        System.out.println("Standardni odklon je: " + odklon);
    }
    public static double povprecje(int[] tab) {
        int vsota = 0;
        for (int i = 0; i < tab.length; i++) {
            vsota += tab[i];
        }
        double length = tab.length;
        double povp = vsota / length;
        return povp;
    }
    public static void frekvenca(int[] tab) {
        int[] fr = new int [tab.length];
        int visited = -1;
        for (int i = 0; i < tab.length; i++) {
            int counter = 1;
            for (int j = i+1; j < tab.length; j++) {
                if (tab[i] == tab[j]) {
                    counter++;
                    fr[j] = visited;
                }
            }
            if (fr[i] != visited) {
                fr[i] = counter;
            }
        }
        int najveckrat = tab[0];
        int max = fr[0];
        for (int i = 0; i < fr.length; i++) {
            if (fr[i] != visited) {
                double length = tab.length;
                double frProcenti = (fr[i] * 100)/length;
                System.out.println("Frekvenca pojavitve " + tab[i] + " je: " + frProcenti + " %");
            }
            if (fr[i] > max) {
                max = fr[i];
                najveckrat = tab[i];
            }
        }
        System.out.println("Največkrat se pojavi število: " + najveckrat);
    }
    public static void stSodihLihih(int[] tab) {
        int counter = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) counter++;
        }
        int liha = tab.length-counter;
        System.out.println("Število sodih: " + counter);
        System.out.println("Število lihih: " + liha);
    }
    public static void stRazlicnih(int[] tab) {
        int counter = 1;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i-1] != tab[i]) {
                counter++;
            }
        }
        System.out.println("Število različnih števil je: " + counter);
    }
    public static int[] sortiraj(int[] tab) {
        Arrays.sort(tab);
        return tab;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Koliko števil boš vnesel? ");
        int vnos = sc.nextInt();
        if (vnos != 0) {
            int[] tab_stevil = new int[vnos];
            for (int i = 0; i < vnos; i++) {
                tab_stevil[i] = sc.nextInt();
            }
            int[] sortirana = sortiraj(tab_stevil);

            // število elementov (števil)
            System.out.println("Število elementov: " + tab_stevil.length);
            // število različnih števil
            stRazlicnih(sortirana);
            // število sodih in lihih števil
            stSodihLihih(tab_stevil);
            // frekvenco pojavitev vsakega števila (v procentih) in število ki se največkrat ponovi
            frekvenca(tab_stevil);
            // največje število
            System.out.println("Največje število je: " + sortirana[sortirana.length-1]);
            // drugo najmanjšo vrednost števil
            System.out.println("Druga najmanjša vrednost števil je: " + sortirana[1]);
            // povprečje vseh števil
            System.out.println("Povprečje je: " + povprecje(tab_stevil));
            // standardni odklon
            standardniOdklon(tab_stevil);
            // mediana
            mediana(sortirana);
            // vsota vseh števil
            vsota(tab_stevil);
            // koliko palindromov
            kolikoPalindromov(tab_stevil);
        }
    }
}
