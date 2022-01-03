public class Kvadrat {
    Daljica diagonala;
    Tocka A;
    Tocka B;
    Tocka C;
    Tocka D;

    public Kvadrat(Daljica diagonala) {
        this.diagonala = diagonala;
        A = diagonala.A;
        C = diagonala.B;
        B = new Tocka(C.getX(), A.getY());
        D = new Tocka(A.getX(), C.getY());
    }
    public double obseg() {
        Daljica AB = new Daljica(A, B);
        return 4 * AB.length();
    }
    public double ploscina() {
        Daljica AB = new Daljica(A, B);
        return AB.length() * AB.length();
    }
}
