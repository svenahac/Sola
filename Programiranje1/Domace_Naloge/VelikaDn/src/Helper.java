import java.util.Arrays;

public class Helper {
    public static void rikverc (int[] tab) {
        for (int i = tab.length-1; i >= 0 ; i--) { // Obrnemo elemente in jih izpišemo
            if (i != 0) {
                System.out.print(tab[i] + ", ");
            } else {
                System.out.print(tab[i]);
            }
        }
    }
    public static void najPalindrom(int[] tab) {
        // Pogledamo koliko palindromov je v tabeli
        int counter = 0;
        for (int i = 0; i < tab.length; i++) {
            if (palindrom(tab[i])) {
                counter++;
            }
        }

        // Naredimo novo tabelo palindromov
        int[] tabPalindromov = new int[counter];
        int cnt = 0;
        for (int i = 0; i < tab.length; i++) {
            if (palindrom(tab[i])) {
                tabPalindromov[cnt] = tab[i];
                cnt++;
            }
        }
        cnt--; // Zmanjšamo števec za 1, da dobimo indeks zadnjega elementa v tabeli

        if ( cnt < 0) { // Pogledamo, če tabela palindromov obstaja
            System.out.println("V tabeli nimamo palindromov, saj imamo samo negativna števila");
        } else if (tabPalindromov[cnt] == 0) { // Pogledamo, če je največji palindrom enak 0
            System.out.println("Drugo največje palindromo število: Ne obstaja, saj je 0 najmanjše");
        } else {
            // Najdemo 2 največji palindrom, tudi, če ga ni v tabeli
            int max = tabPalindromov[cnt] - 1;
            while (true) {
                if (palindrom(max)) {
                    System.out.println("Drugo največje palindromo število : " + max);
                    break;
                } else {
                    max--;
                }
            }
        }
    }
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
        String a = Integer.toString(stevilo); // Pretvorimo int v string
        StringBuilder ss = new StringBuilder(a);
        String tmp = ss.reverse().toString(); // Obrne črke v nizu
        if(tmp.contentEquals(a)) { // Primerjamo niz z obrnjenim nizom
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
        for (int i = 0; i < tab.length; i++) { // Sprehodi se po tabeli
            int counter = 1; // Števec pojavitve števila nastavimo na 1
            for (int j = i+1; j < tab.length; j++) { // Ponovno se sprehodimo skozi tabelo iz naslednjega mesta od prejšnega št.
                if (tab[i] == tab[j]) { // Če najdemo enako število:
                    counter++; // Povečamo števec števil
                    fr[j] = visited; // Spremenimo mesto, da vemo, da smo tukaj že bili
                }
            }
            if (fr[i] != visited) { // Pogledamo, če smo že obdelali to število
                fr[i] = counter; // Če nismo v tabelo zapišemo kolikokrat se je pojavilo
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
        int liha = tab.length-counter; // Kar ni sodo je liho
        System.out.println("Število sodih: " + counter);
        System.out.println("Število lihih: " + liha);
    }
    public static void drugaNaj(int[] tab) {
        int counter = 1;
        int drugoNaj = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i - 1] != tab[i]) { // Pogleda sosednja elementa v urejeni tabeli in pove, če sta rezlična
                drugoNaj = tab[i]; // Nasli smo drugo najvecje stevilo
                break;
            }
        }
        System.out.println("Drugo najmanjše število je: " + drugoNaj);
    }

        public static void stRazlicnih(int[] tab) {
        int counter = 1;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i-1] != tab[i]) { // Pogleda sosednja elementa v urejeni tabeli in pove, če sta rezlična
                counter++;
            }
        }
        System.out.println("Število različnih števil je: " + counter);
    }
    public static int[] sortiraj(int[] tab) {
        Arrays.sort(tab); // Z metodo sort, sortira tabelo
        return tab;
    }
}
