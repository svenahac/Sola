public class Main {
    public static void main(String[] args) {
        Tocka A = new Tocka(0, 0);
        Tocka B = new Tocka(1, 1);

        Daljica d = new Daljica(A, B);
        System.out.println(d.length());

        Kvadrat kvadrat = new Kvadrat(d);
        Kocka k = new Kocka(kvadrat, 2);
        System.out.println(k.volume());

        Trikotnik trikotnik = new Trikotnik(d, new Tocka(0,1));
        System.out.println(trikotnik.ploscina());
    }
}
